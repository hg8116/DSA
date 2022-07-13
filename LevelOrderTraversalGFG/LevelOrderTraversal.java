// https://practice.geeksforgeeks.org/problems/level-order-traversal/1

package LevelOrderTraversalGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static ArrayList <Integer> levelOrder(Node node)
    {
        ArrayList<Integer> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node temp = q.poll();
            res.add(temp.data);

            if(temp.left != null){
                q.add(temp.left);
            }

            if(temp.right != null){
                q.add(temp.right);
            }
        }

        return res;
    }

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
}
