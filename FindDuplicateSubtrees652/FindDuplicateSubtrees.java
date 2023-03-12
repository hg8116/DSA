// https://leetcode.com/problems/find-duplicate-subtrees/description/

package FindDuplicateSubtrees652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, ans, map);
        return ans;
    }

    String helper(TreeNode root, List<TreeNode> ans, Map<String, Integer> map) {
        if (root == null)
            return "";
        String left = helper(root.left, ans, map);
        String right = helper(root.right, ans, map);

        int curr = root.val;
        String str = curr + "$" + left + "$" + right;
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2)
            ans.add(root);

        return str;
    }
}
