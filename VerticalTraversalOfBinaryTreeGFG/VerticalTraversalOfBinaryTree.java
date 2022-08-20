// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1

package VerticalTraversalOfBinaryTreeGFG;

import java.util.*;

public class VerticalTraversalOfBinaryTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class Pair {
        int hd;
        Node node;

        Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (map.containsKey(temp.hd)) {
                map.get(temp.hd).add(temp.node.data);
            } else {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(temp.node.data);
                map.put(temp.hd, sub);
            }

            if (temp.node.left != null)
                q.add(new Pair(temp.hd - 1, temp.node.left));
            if (temp.node.right != null)
                q.add(new Pair(temp.hd + 1, temp.node.right));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }

        return ans;
    }

}
