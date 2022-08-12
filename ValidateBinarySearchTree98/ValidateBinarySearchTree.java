// https://leetcode.com/problems/validate-binary-search-tree/

package ValidateBinarySearchTree98;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        return search(root);
    }

    TreeNode prev = null;

    public boolean search(TreeNode root) {
        if (root == null)
            return true;

        if (!search(root.left))
            return false;
        if (prev != null && root.val <= prev.val)
            return false;
        if (!search(root.right))
            return false;
        return true;
    }
}
