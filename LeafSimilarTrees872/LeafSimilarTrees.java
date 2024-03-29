// https://leetcode.com/problems/leaf-similar-trees/description/

package LeafSimilarTrees872;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        findInorder(root1, list1);
        findInorder(root2, list2);
        System.out.println(list1);
        System.out.println(list2);
        return list1.equals(list2);
    }

    void findInorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        findInorder(root.left, list);
        if (root.left == null && root.right == null)
            list.add(root.val);
        findInorder(root.right, list);
    }
}
