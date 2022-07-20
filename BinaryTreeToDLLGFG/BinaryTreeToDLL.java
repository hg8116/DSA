// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

package BinaryTreeToDLLGFG;

public class BinaryTreeToDLL {
    class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node prev = null, head = null;
    Node bToDLL(Node root){
        if(root == null) return null;
        bToDLL(root.left);
        if(prev == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLL(root.right);

        return head;
    }
}
