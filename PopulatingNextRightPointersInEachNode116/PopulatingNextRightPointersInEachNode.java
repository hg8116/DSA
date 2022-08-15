// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

package PopulatingNextRightPointersInEachNode116;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // Method 1 - recursive approach
    public Node connect(Node root) {
        if (root == null) return null;
        connectLink(root.left, root.right);
        return root;
    }

    public void connectLink(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;

        n1.next = n2;
        connectLink(n1.left, n1.right);
        connectLink(n2.left, n2.right);
        connectLink(n1.right, n2.left);
    }

    // Method 2 - iterative approach
    public Node connectItr(Node root) {
        if (root == null) return root;

        Node temp = root;
        while (temp != null) {
            Node currLevel = temp;
            while (temp != null) {
                if (temp.left != null)
                    temp.left.next = temp.right;
                if (temp.right != null && temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }

            temp = currLevel.left;
        }

        return root;
    }
}