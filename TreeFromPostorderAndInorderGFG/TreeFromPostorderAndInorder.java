// https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1

package TreeFromPostorderAndInorderGFG;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPostorderAndInorder {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    Node buildTree(int in[], int post[], int n) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<n; i++){
            inMap.put(in[i], i);
        }

        return helper(in, 0, n-1, post, 0, n-1, inMap);
    }

    Node helper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || postStart > postEnd) return null;

        Node root = new Node(post[postEnd]);
        int inRoot = inMap.get(root.data);
        int leftNum = inRoot - inStart;

        root.left = helper(in, inStart, inRoot - 1, post, postStart, postStart + leftNum - 1, inMap);
        root.right = helper(in, inRoot + 1, inEnd, post, postStart + leftNum, postEnd - 1, inMap);

        return root;
    }
}
