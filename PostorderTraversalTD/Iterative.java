package PostorderTraversalTD;

// Iterative Approach

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative {
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
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        Stack<Integer> out = new Stack<>();

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            out.push(curr.data);

            if(curr.left != null){
                stack.push(curr.left);
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }

        while(!out.isEmpty()){
            ans.add(out.pop());
        }

        return ans;
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
