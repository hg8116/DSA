// https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

package CheckForBalancedTreeGFG;

public class Method1 {
    class Node
    {
        int data;
        Node left,right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    // Method 1 -
    // TC - O(N)
    int findHeight(Node node){
        if(node == null){
            return 0;
        }

        int leftH = findHeight(node.left);
        int rightH = findHeight(node.right);

        return Math.max(leftH, rightH) + 1;
    }

    boolean isBalanced(Node root){
        if(root == null) return true;

        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);

        if(Math.abs(leftH - rightH) > 1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if(!left || !right) return false;

        return true;
    }
}
