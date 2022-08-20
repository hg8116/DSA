// https://leetcode.com/problems/path-sum-ii/

package PathSumII113;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<Integer>(), ans);
        return ans;
    }

    public void pathSum(TreeNode root, int sum, ArrayList<Integer> sol, List<List<Integer>> ans) {
        if (root == null) return;

        sol.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<Integer>(sol));
        }
        pathSum(root.left, sum - root.val, sol, ans);
        pathSum(root.right, sum - root.val, sol, ans);

        sol.remove(sol.size() - 1);
    }

}
