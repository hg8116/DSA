// https://leetcode.com/problems/cousins-in-binary-tree-ii/

package CousinsInBinaryTreeII2641;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBinaryTreeII {
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

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Map<Integer, Integer> map = new HashMap<>();

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            map.put(level, sum);
            level++;
        }

        System.out.println(map);

        root.val = 0;
        q.add(root);
        level = 0;
        while (!q.isEmpty() && level < map.size() - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                int nextLevelSum = map.get(level + 1);
                if (node.left != null && node.right != null) {
                    int leftCopy = node.left.val;
                    int rightCopy = node.right.val;
                    node.left.val = nextLevelSum - leftCopy - rightCopy;
                    node.right.val = nextLevelSum - leftCopy - rightCopy;
                } else if (node.left != null) {
                    node.left.val = nextLevelSum - node.left.val;
                } else if (node.right != null) {
                    node.right.val = nextLevelSum - node.right.val;
                }
            }
            level++;
        }

        return root;
    }
}
