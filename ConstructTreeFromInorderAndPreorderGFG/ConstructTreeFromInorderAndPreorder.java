// https://practice.geeksforgeeks.org/problems/construct-tree-1/1

package ConstructTreeFromInorderAndPreorderGFG;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInorderAndPreorder {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static Node buildTree(int inorder[], int preorder[], int n){
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<n; i++){
            inMap.put(inorder[i], i);
        }

        return helper(inorder, 0, n-1, preorder, 0, n-1, inMap);
    }

    public static Node helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || preStart > preEnd) return null;

        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = helper(inorder, inStart, inRoot - 1, preorder, preStart + 1, preStart + numLeft, inMap);
        root.right = helper(inorder, inRoot + 1, inEnd, preorder, preStart + numLeft + 1, preEnd, inMap);

        return root;
    }
}
