// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

package ConvertSortedArrayToBST108;

public class ConvertSortedArrayToBST {
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

    TreeNode formTree(int[] nums, int s, int e) {
        if (s > e)
            return null;

        int mid = s + (e - s) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = formTree(nums, s, mid - 1);
        node.right = formTree(nums, mid + 1, e);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return formTree(nums, 0, nums.length - 1);
    }
}
