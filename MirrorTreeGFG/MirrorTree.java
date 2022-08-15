// https://practice.geeksforgeeks.org/problems/mirror-tree/1

package MirrorTreeGFG;

public class MirrorTree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void mirror(Node node) {
        if (node == null) return;

        mirror(node.left);
        mirror(node.right);

        Node l = node.left;
        Node r = node.right;

        node.left = r;
        node.right = l;
    }
}