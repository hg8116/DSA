// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1

package TransformToSumTreeGFG;

public class TransformToSumTree {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public void toSumTree(Node root) {
        sumTree(root);
    }

    int sumTree(Node root){
        if(root == null) return 0;
        int oldVal = root.data;

        root.data = sumTree(root.left) + sumTree(root.right);

        return oldVal + root.data;
    }
}
