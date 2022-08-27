// https://leetcode.com/problems/number-of-provinces/

package NumberOfProvinces547;

import java.util.ArrayList;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = isConnected[0].length;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, adj);
            }
        }

        return count;
    }

    public void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        for (Integer it : adj.get(i)) {
            if (!vis[it])
                dfs(it, vis, adj);
        }
    }
}
