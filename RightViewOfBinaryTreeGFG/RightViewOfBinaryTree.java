// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

package RightViewOfBinaryTreeGFG;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
    private class Node
    {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        findRightView(node, ans, 0);
        return ans;
    }

    void findRightView(Node node, ArrayList<Integer> ans, int level){
        if(node == null){
            return;
        }

        if(level == ans.size()){
            ans.add(node.data);
        }
        findRightView(node.right, ans, level + 1);
        findRightView(node.left, ans, level + 1);
    }
}
