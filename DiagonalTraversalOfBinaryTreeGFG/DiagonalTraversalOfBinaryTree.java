// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

package DiagonalTraversalOfBinaryTreeGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalOfBinaryTree {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public ArrayList<Integer> diagonal(Node root){
        if(root == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            while(curr != null){
                if(curr.left != null) q.add(curr.left);
                ans.add(curr.data);
                curr = curr.right;
            }
        }

        return ans;
    }
}
