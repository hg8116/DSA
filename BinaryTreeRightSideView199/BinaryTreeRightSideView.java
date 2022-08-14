// https://leetcode.com/problems/binary-tree-right-side-view/

package BinaryTreeRightSideView199;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        findView(root, ans, 0);
        return ans;
    }

    public void findView(TreeNode root, List<Integer> ans, int currDepth) {
        if (root == null) return;

        if (ans.size() == currDepth)
            ans.add(root.val);

        findView(root.right, ans, currDepth + 1);
        findView(root.left, ans, currDepth + 1);
    }
}