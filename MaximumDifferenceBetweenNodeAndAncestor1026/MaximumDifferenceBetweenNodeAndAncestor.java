// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

package MaximumDifferenceBetweenNodeAndAncestor1026;

public class MaximumDifferenceBetweenNodeAndAncestor {
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

    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    int helper(TreeNode root, int min, int max) {
        if (root == null)
            return Math.abs(min - max);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int l = helper(root.left, min, max);
        int r = helper(root.right, min, max);

        return Math.max(l, r);
    }
}
