// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

package LongestZigZagPathInABinaryTree1372;

public class LongestZigZagPathInABinaryTree {
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

    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;

        return Math.max(helper(root.left, 1, 1, false), helper(root.right, 1, 1, true));
    }

    int helper(TreeNode root, int count, int max, boolean dir) {
        if (root == null)
            return max;

        max = Math.max(max, count);
        if (dir)
            return Math.max(helper(root.left, count + 1, max, !dir), helper(root.right, 1, max, dir));
        else
            return Math.max(helper(root.right, count + 1, max, !dir), helper(root.left, 1, max, dir));
    }
}
