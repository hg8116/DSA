// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

package MinimumTimeToCollectAllApplesInATree1443;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : edges) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        return helper(0, -1, adj, hasApple);
    }

    int helper(int i, int par, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        for (Integer it : adj.get(i)) {
            if (it == par)
                continue;

            int childTime = helper(it, i, adj, hasApple);
            if (childTime > 0 || hasApple.get(it))
                time += childTime + 2;
        }
        return time;
    }
}
