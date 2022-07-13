// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#

package LeftViewOfBinaryTreeGFG;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
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

    ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        findLeftView(root, ans, 0);
        return ans;
    }

    void findLeftView(Node node, List<Integer> ans, int level){
        if(node == null){
            return;
        }

        if(level == ans.size()){
            ans.add(node.data);
        }
        findLeftView(node.left, ans, level + 1);
        findLeftView(node.right, ans, level + 1);
    }
}
