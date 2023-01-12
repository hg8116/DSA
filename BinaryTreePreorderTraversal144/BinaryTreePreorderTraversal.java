// https://leetcode.com/problems/binary-tree-preorder-traversal/

package BinaryTreePreorderTraversal144;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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

    List<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        preorder(root);
        return ans;
    }

    void preorder(TreeNode root) {
        if (root == null)
            return;

        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
