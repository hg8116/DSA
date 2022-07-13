// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1#

package DiameterOfABinaryTreeGFG;

import com.sun.source.tree.Tree;

public class DiameterOfABinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Method 1 - O(N^2)

    int diameter(Node root){
        if(root == null){
            return 0;
        }

        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(Math.max(dia1, dia2), dia3);
    }

    int height(Node node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method 2 - O(N)
    class TreeInfo{
        int dia;
        int ht;

        TreeInfo(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }

    TreeInfo height2(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = height2(root.left);
        TreeInfo right = height2(root.right);

        int maxHeight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int maxDia = Math.max(Math.max(dia1, dia2), dia3);
        return new TreeInfo(maxDia, maxHeight);
    }
}
