// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

package MinimumFuelCostToReportToTheCapital2477;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0)
            return 0;
        ans = 0;
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] x : roads) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }

        boolean[] vis = new boolean[n];
        dfs(0, vis, adj, seats);
        return ans;
    }

    long dfs(int node, boolean[] vis, List<List<Integer>> adj, int seats) {
        vis[node] = true;
        long count = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == false)
                count += dfs(it, vis, adj, seats);
        }

        long x = count / seats;
        if (count % seats != 0)
            x++;
        if (node != 0)
            ans += x;
        return count;
    }
}
