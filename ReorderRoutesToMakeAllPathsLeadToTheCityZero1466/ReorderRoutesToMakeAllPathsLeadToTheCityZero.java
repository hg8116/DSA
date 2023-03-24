import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : connections) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(-x[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[n];

        int ans = 0;
        q.add(0);
        vis[0] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int it : adj.get(Math.abs(curr))) {
                if (vis[Math.abs(it)] == 0) {
                    q.add(it);
                    vis[Math.abs(it)] = 1;
                    if (it > 0)
                        ans++;
                }
            }
        }
        return ans;
    }
}