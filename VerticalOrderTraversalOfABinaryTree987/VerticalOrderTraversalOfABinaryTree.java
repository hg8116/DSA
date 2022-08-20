// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

package VerticalOrderTraversalOfABinaryTree987;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
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
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            while (size-- > 0) {
                Pair curr = q.poll();
                int dist = curr.hd;
                List<Integer> nodeList = levelMap.getOrDefault(dist, new ArrayList<>());
                nodeList.add(curr.node.val);
                Collections.sort(nodeList);
                levelMap.put(dist, new ArrayList<>(nodeList));

                if (curr.node.left != null)
                    q.add(new Pair(dist - 1, curr.node.left));
                if (curr.node.right != null)
                    q.add(new Pair(dist + 1, curr.node.right));
            }
            for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
                List<Integer> nodeList = map.getOrDefault(entry.getKey(), new ArrayList<>());
                nodeList.addAll(entry.getValue());
                map.put(entry.getKey(), nodeList);
            }
        }
        return new ArrayList<>(map.values());
    }

}
