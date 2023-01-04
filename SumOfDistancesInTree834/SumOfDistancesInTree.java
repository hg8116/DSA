// https://leetcode.com/problems/sum-of-distances-in-tree/

package SumOfDistancesInTree834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        int[] childCount = new int[n];
        Arrays.fill(childCount, 1);

        int[] ans = new int[n];

        dfsBase(0, -1, childCount, ans, adj);
        dfsFill(0, -1, childCount, ans, adj);

        return ans;
    }

    void dfsBase(int i, int par, int[] childCount, int[] ans, List<List<Integer>> adj) {
        for (Integer it : adj.get(i)) {
            if (it == par)
                continue;
            dfsBase(it, i, childCount, ans, adj);
            childCount[i] += childCount[it];
            ans[i] += ans[it] + childCount[it];
        }
    }

    void dfsFill(int i, int par, int[] childCount, int[] ans, List<List<Integer>> adj) {
        for (Integer it : adj.get(i)) {
            if (it == par)
                continue;
            ans[it] = ans[i] + (adj.size() - 2 * childCount[it]);
            dfsFill(it, i, childCount, ans, adj);
        }
    }
}
