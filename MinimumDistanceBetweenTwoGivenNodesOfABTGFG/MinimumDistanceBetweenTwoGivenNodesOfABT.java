// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

package MinimumDistanceBetweenTwoGivenNodesOfABTGFG;

public class MinimumDistanceBetweenTwoGivenNodesOfABT {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int findDist(Node root, int a, int b) {
        Node LCA = findLCA(root, a, b);
        int distA = findDist(LCA, a);
        int distB = findDist(LCA, b);

        return distA + distB - 2;
    }

    Node findLCA(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b) return root;

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    int findDist(Node root, int val) {
        if (root == null) return 0;
        if (root.data == val) return 1;

        int left = findDist(root.left, val);
        int right = findDist(root.right, val);

        if (left == 0 && right == 0) return 0;
        return left + right + 1;
    }
}