// https://practice.geeksforgeeks.org/problems/check-for-bst/1

package CheckForBSTGFG;

public class CheckForBST {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    boolean isBST(Node root) {
        return search(root);
    }

    Node prev = null;

    boolean search(Node root) {
        if (root == null) return true;

        if (!search(root.left)) return false;
        if (prev != null && prev.data > root.data) return false;
        prev = root;
        if (!search(root.right)) return false;

        return true;
    }

}
