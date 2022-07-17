// https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1

package ZigZagTreeTraversalGFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {
    class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    ArrayList<Integer> zigZagTraversal(Node root){
        if(root == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        boolean rightToLeft = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                Node curr = q.poll();
                temp.add(curr.data);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(rightToLeft != true){
                Collections.reverse(temp);
            }
            for(int i=0; i<temp.size(); i++){
                ans.add(temp.get(i));
            }

            rightToLeft = !rightToLeft;
        }

        return ans;
    }
}
