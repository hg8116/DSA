// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

package MaximumProductOfSplittedBinaryTree1339;

public class MaximumProductOfSplittedBinaryTree {
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

    static int MOD = (int) (1e9 + 7);
    long maxProduct = 0l;
    int total = 0;

    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        total = findSum(root);

        findSum(root);
        return (int) (maxProduct % MOD);
    }

    int findSum(TreeNode root) {
        if (root == null)
            return 0;

        int left = findSum(root.left);
        int right = findSum(root.right);
        int sumSubTree = root.val + left + right;

        int remainingSum = total - sumSubTree;
        maxProduct = Math.max(maxProduct, (long) sumSubTree * remainingSum);

        return sumSubTree;
    }
}
