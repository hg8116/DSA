// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

package MaximumWidthOfBinaryTree662;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
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

    class Pair {
        TreeNode node;
        int id;

        Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().id;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int currId = q.peek().id - min;
                TreeNode currNode = q.peek().node;
                q.poll();

                if (i == 0)
                    first = currId;
                if (i == size - 1)
                    last = currId;
                if (currNode.left != null)
                    q.add(new Pair(currNode.left, currId * 2 + 1));
                if (currNode.right != null)
                    q.add(new Pair(currNode.right, currId * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
