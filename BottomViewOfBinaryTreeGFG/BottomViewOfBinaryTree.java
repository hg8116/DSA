// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

package BottomViewOfBinaryTreeGFG;

import java.util.*;

public class BottomViewOfBinaryTree {
    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    private static class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root){
        if(root == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()){
            Pair curr = q.poll();
            map.put(curr.hd, curr.node.data);
            if(curr.node.left != null){
                q.add(new Pair(curr.node.left, curr.hd - 1));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.node.right, curr.hd + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
