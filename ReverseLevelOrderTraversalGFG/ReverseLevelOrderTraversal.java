// https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#

package ReverseLevelOrderTraversalGFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    private class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<Integer> reverseLevelOrder(Node node){
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while(!q.isEmpty()){
            Node temp = q.poll();
            res.add(temp.data);

            if(temp.right != null){
                q.add(temp.right);
            }

            if(temp.left != null){
                q.add(temp.left);
            }
        }

        Collections.sort(res);

        return res;
    }
}
