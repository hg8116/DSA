// https://leetcode.com/problems/balanced-binary-tree/

package BalancedBinaryTree110;

public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);

        if (Math.abs(leftH - rightH) > 1) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (!left || !right) return false;
        return true;
    }

    public int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return Math.max(left, right) + 1;
    }
}