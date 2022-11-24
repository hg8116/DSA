// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/

package ClosestNodesQueriesInABinarySearchTree2476;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


public class ClosestNodesQueriesInABinarySearchTree {
    class TreeNode {
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

    // Approach 1 - TreeSet
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        populate(root, set);

        for (int x : queries) {
            List<Integer> temp = new ArrayList<>();
            temp.add(set.floor(x) == null ? -1 : set.floor(x));
            temp.add(set.ceiling(x) == null ? -1 : set.ceiling(x));
            ans.add(temp);
        }

        return ans;
    }

    void populate(TreeNode root, TreeSet<Integer> set) {
        if (root == null)
            return;
        populate(root.left, set);
        set.add(root.val);
        populate(root.right, set);
    }

    // Approach 2 - Binary Search

    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        findInorder(root, inorder);
        List<List<Integer>> ans = new ArrayList<>();
        int n = inorder.size();
        for (int x : queries) {
            if (x < inorder.get(0))
                ans.add(Arrays.asList(-1, inorder.get(0)));
            else if (x > inorder.get(n - 1))
                ans.add(Arrays.asList(inorder.get(n - 1), -1));
            else {
                int l = 0;
                int h = n - 1;
                boolean found = false;
                while (l <= h) {
                    int mid = l + (h - l) / 2;
                    if (x == inorder.get(mid)) {
                        found = true;
                        ans.add(Arrays.asList(x, x));
                        break;
                    } else if (x > inorder.get(mid))
                        l = mid + 1;
                    else
                        h = mid - 1;
                }
                if (!found)
                    ans.add(Arrays.asList(inorder.get(l - 1), inorder.get(l)));
            }
        }
        return ans;
    }


    void findInorder(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        findInorder(root.left, inorder);
        inorder.add(root.val);
        findInorder(root.right, inorder);
    }

}
