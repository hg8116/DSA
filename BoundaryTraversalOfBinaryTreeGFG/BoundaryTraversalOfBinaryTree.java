// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

package BoundaryTraversalOfBinaryTreeGFG;

import java.util.ArrayList;

public class BoundaryTraversalOfBinaryTree {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    boolean isLeaf(Node node){
        return (node.left == null) && (node.right == null);
    }

    void addLeftBoundary(Node node, ArrayList<Integer> ans){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(node) == false) ans.add(node.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    void addRightBoundary(Node node, ArrayList<Integer> ans){
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(node) == false) temp.add(node.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for(int i=temp.size() - 1; i>=0; i--){
            ans.add(temp.get(i));
        }
    }

    void  addLeaf(Node node, ArrayList<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }

        if(node.left != null)addLeaf(node.left, ans);
        if(node.right != null)addLeaf(node.right, ans);
    }

    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(node) == false) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaf(node, ans);
        addRightBoundary(node, ans);

        return ans;
    }
}
