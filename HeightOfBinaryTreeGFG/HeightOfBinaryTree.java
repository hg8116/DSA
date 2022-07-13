// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1

package HeightOfBinaryTreeGFG;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
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


    // Recursive approach

    int height(Node node){
        return calc(node);
    }

    int calc(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = calc(node.left);
        int rightHeight = calc(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Iterative approach

    int height2(Node node){
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        q.add(null);

        int height = 0;

        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp == null){
                height++;
            }

            if(temp != null){
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            else if(!q.isEmpty()){
                q.add(null);
            }
        }

        return height;
    }

}
