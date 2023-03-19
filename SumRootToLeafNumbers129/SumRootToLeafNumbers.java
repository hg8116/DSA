// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

package SumRootToLeafNumbers129;

public class SumRootToLeafNumbers {
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

    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return sum;
    }

    void helper(TreeNode root, String str) {
        if (root == null)
            return;
        str += root.val;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(str);
            return;
        }

        helper(root.left, str);
        helper(root.right, str);
    }
}
