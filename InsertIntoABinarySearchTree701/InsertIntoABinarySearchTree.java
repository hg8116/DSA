// https://leetcode.com/problems/insert-into-a-binary-search-tree/

package InsertIntoABinarySearchTree701;

public class InsertIntoABinarySearchTree {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode temp = root;
        while (true) {
            if (root.val <= val) {
                if (root.right != null) root = root.right;
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else if (root.val > val) {
                if (root.left != null) root = root.left;
                else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}