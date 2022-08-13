// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

package BinaryTreeZigzagLevelOrderTraversal103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            TreeNode temp;
            List<Integer> sub = new ArrayList<>();
            while (!s1.isEmpty()) {
                temp = s1.pop();
                sub.add(temp.val);

                if (temp.left != null) s2.push(temp.left);
                if (temp.right != null) s2.push(temp.right);
            }

            ans.add(sub);
            sub = new ArrayList<Integer>();
            while (!s2.isEmpty()) {
                temp = s2.pop();
                sub.add(temp.val);
                if (temp.right != null) s1.push(temp.right);
                if (temp.left != null) s1.push(temp.left);
            }
            if (!sub.isEmpty())
                ans.add(sub);
        }

        return ans;
    }
}
