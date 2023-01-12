// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

package NumberOfNodesInTheSubTreeWithTheSameLabel1519;

import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        ans = new int[n];
        helper(0, -1, adj, labels);
        return ans;
    }

    int[] helper(int cur, int par, List<List<Integer>> adj, String labels) {
        int[] count = new int[26];
        for (Integer it : adj.get(cur)) {
            if (it == par)
                continue;
            int[] temp = helper(it, cur, adj, labels);
            for (int i = 0; i < temp.length; i++)
                count[i] += temp[i];
        }
        ans[cur] = ++count[labels.charAt(cur) - 'a'];
        return count;
    }
}