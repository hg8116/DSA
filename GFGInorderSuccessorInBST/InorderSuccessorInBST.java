// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1

package GFGInorderSuccessorInBST;

public class InorderSuccessorInBST {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public Node inorderSuccessor(Node root, Node x) {
        Node succ = null;

        while (root != null) {
            if (root.data <= x.data)
                root = root.right;
            else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}