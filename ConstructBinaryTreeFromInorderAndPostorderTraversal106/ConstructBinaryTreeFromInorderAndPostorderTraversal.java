// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

package ConstructBinaryTreeFromInorderAndPostorderTraversal106;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    int postEnd;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0)
            return null;
        postEnd = postorder.length - 1;
        return helper(inorder, postorder, 0, postEnd);
    }

    TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode curr = new TreeNode(postorder[postEnd--]);
        if (start == end)
            return curr;

        int index = 0;
        for (int i = end; i >= 0; i--) {
            if (inorder[i] == curr.val) {
                index = i;
                break;
            }
        }
        curr.right = helper(inorder, postorder, index + 1, end);
        curr.left = helper(inorder, postorder, start, index - 1);

        return curr;
    }
}
