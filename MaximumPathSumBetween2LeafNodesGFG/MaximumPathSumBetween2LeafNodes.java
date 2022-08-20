// https://practice.geeksforgeeks.org/problems/maximum-path-sum/1

package MaximumPathSumBetween2LeafNodesGFG;

public class MaximumPathSumBetween2LeafNodes {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int maxPathSum(Node root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        int s = findSum(root, ans);
        if (root.left == null || root.right == null)
            ans[0] = Math.max(s, ans[0]);

        return ans[0];
    }

    int findSum(Node node, int[] ans) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;
        int left = Math.max(Integer.MIN_VALUE, findSum(node.left, ans));
        int right = Math.max(Integer.MIN_VALUE, findSum(node.right, ans));

        if (node.left == null) return node.data + right;
        if (node.right == null) return node.data + left;
        ans[0] = Math.max((left + right + node.data), ans[0]);
        return Math.max(left, right) + node.data;
    }

}
