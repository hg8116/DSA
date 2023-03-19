// https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

package CheckCompletenessOfABinaryTree958;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.peek() != null) {
            TreeNode curr = q.poll();
            q.add(curr.left);
            q.add(curr.right);
        }

        while (!q.isEmpty() && q.peek() == null)
            q.poll();

        return q.isEmpty();
    }
}
