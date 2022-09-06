// https://leetcode.com/problems/binary-tree-pruning/

package BinaryTreePruning814;

public class BinaryTreePruning {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        root = find(root);
        return root;
    }

    TreeNode find(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = find(root.left);
        TreeNode right = find(root.right);

        if (left == null)
            root.left = null;
        if (right == null)
            root.right = null;

        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
            return null;
        }

        return root;
    }
}
