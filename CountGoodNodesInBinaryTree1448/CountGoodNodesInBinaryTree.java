// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

package CountGoodNodesInBinaryTree1448;

public class CountGoodNodesInBinaryTree {
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

    int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        // max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
