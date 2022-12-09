// https://leetcode.com/problems/range-sum-of-bst/description/

package RangeSumOfBST938;

public class RangeSumOfBST938 {
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

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        findInorder(low, high, root);
        return sum;
    }

    void findInorder(int low, int high, TreeNode root) {
        if (root == null)
            return;
        findInorder(low, high, root.left);
        if (low <= root.val && root.val <= high)
            sum += root.val;
        findInorder(low, high, root.right);
    }
}
