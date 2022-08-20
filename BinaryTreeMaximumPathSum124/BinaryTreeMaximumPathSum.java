// https://leetcode.com/problems/binary-tree-maximum-path-sum/

package BinaryTreeMaximumPathSum124;

public class BinaryTreeMaximumPathSum {
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

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        findMax(root, ans);
        return ans[0];
    }

    public int findMax(TreeNode node, int[] ans) {
        if (node == null) return 0;
        int left = Math.max(0, findMax(node.left, ans));
        int right = Math.max(0, findMax(node.right, ans));

        ans[0] = Math.max((left + right + node.val), ans[0]);
        return Math.max(left, right) + node.val;
    }
}