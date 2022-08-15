// https://leetcode.com/problems/diameter-of-binary-tree/

package DiameterOfBinaryTree543;

public class DiameterOfBinaryTree {
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

    public class Pair {
        int height, dia;

        Pair() {
        }

        Pair(int height, int dia) {
            this.height = height;
            this.dia = dia;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Pair ans = findDiameter(root);
        return ans.dia;
    }

    public Pair findDiameter(TreeNode root) {
        if (root == null) return new Pair(0, 0);

        Pair left = findDiameter(root.left);
        Pair right = findDiameter(root.right);

        Pair ans = new Pair();
        ans.dia = Math.max(left.height + right.height, Math.max(left.dia, right.dia));
        ans.height = Math.max(left.height, right.height) + 1;

        return ans;
    }
}