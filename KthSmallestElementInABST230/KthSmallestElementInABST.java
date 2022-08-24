// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package KthSmallestElementInABST230;

public class KthSmallestElementInABST {
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

    int ans = -1, c = 0;

    public int kthSmallest(TreeNode root, int k) {
        findInoder(root, k);
        return ans;
    }

    public void findInoder(TreeNode root, int k) {
        if (root == null) return;
        findInoder(root.left, k);
        if (++c == k) ans = root.val;
        findInoder(root.right, k);
    }
}