// https://practice.geeksforgeeks.org/problems/sum-tree/1

package SumTreeGFG;

public class SumTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    boolean isSumTree(Node root){
        if(root == null) return true;

        int r = check(root);
        if(r == -1) return false;

        return true;
    }

    int check(Node root){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return root.data;
        }
        int l = check(root.left);
        int r = check(root.right);

        if(l == -1 || r == -1) return -1;
        if(root.data == l + r) return root.data + l + r;

        return -1;
    }
}
