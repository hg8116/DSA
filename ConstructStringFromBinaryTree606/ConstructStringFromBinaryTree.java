// https://leetcode.com/problems/construct-string-from-binary-tree/

package ConstructStringFromBinaryTree606;

public class ConstructStringFromBinaryTree {
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

    StringBuilder sb;

    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        find(root);
        return sb.toString();
    }

    void find(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append('(');
        find(root.left);
        sb.append(')');
        if (root.right != null) {
            sb.append('(');
            find(root.right);
            sb.append(')');
        }
        return;
    }

}
