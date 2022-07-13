package PostorderTraversalTD;

// Recursive Approach

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    private static class Node
    {
        int data;			// data field
        Node left, right;	// pointer to the left and right child

        Node() {}
        Node(int data) { this.data = data; this.left = this.right = null; }
    }

    public static List<Integer> findPostorderTraversal(Node root)
    {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    public static void postorder(Node node, List<Integer> ans){
        if(node == null){
            return;
        }

        postorder(node.left, ans);
        postorder(node.right, ans);
        ans.add(node.data);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        List<Integer> ans = findPostorderTraversal(root);
        System.out.println(ans);
    }
}
