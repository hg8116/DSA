// https://leetcode.com/problems/symmetric-tree/

package SymmetricTree101;

import java.util.Stack;

public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Recursive Approach
    public boolean isSymmetricRec(TreeNode root) {
        return (root == null) || check(root.left, root.right);
    }

    public boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        if (n1.left != n2.right)
            return false;
        return check(n1.left, n2.right) && check(n1.right, n1.left);
    }

    // Iterative Approach
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val == n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
}