// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

package MinimumDistanceBetweenBSTNodes783;

public class MinimumDistanceBetweenBSTNodes {
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

    Integer ans = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null)
            minDiffInBST(root.left);
        if (pre != null)
            ans = Math.min(ans, root.val - pre);
        pre = root.val;
        if (root.right != null)
            minDiffInBST(root.right);
        return ans;
    }
}
