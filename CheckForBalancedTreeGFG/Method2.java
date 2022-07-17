// // https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

package CheckForBalancedTreeGFG;

public class Method2 {
    // Method 2 -
    // TC - O(N)
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

    boolean isBalanced(Node root){
        return dfs(root) != -1;
    }

    int dfs(Node node){
        if(node == null){
            return 0;
        }

        int leftH = dfs(node.left);
        if(leftH == -1) return -1;
        int rightH = dfs(node.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;
        return Math.max(leftH, rightH) + 1;

    }
}
