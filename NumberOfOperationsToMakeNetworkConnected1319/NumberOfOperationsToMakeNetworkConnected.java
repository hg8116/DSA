// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

package NumberOfOperationsToMakeNetworkConnected1319;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
    /*
    public int makeConnected(int n, int[][] mat) {
        if (mat.length < n - 1)
            return -1;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int[] x : mat) {
            list.get(x[0]).add(x[1]);
            list.get(x[1]).add(x[0]);
        }

        boolean[] vis = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                dfs(i, vis, list);
                count++;
            }
        }

        return count - 1;
    }

    void dfs(int i, boolean[] vis, List<List<Integer>> adj) {
        vis[i] = true;
        for (Integer it : adj.get(i)) {
            if (vis[it] == false)
                dfs(it, vis, adj);
        }
    }
    */

    // Using DSU
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int group = 0;
        int extra = 0;
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] x : connections) {
            if (union(x[0], x[1], parent))
                extra++;
        }
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i)
                group++;
        }

        return extra >= group - 1 ? group - 1 : -1;
    }

    boolean union(int a, int b, int[] c) {
        if (find(a, c) != find(b, c)) {
            c[c[a]] = c[b];
            return false;
        }
        return true;
    }

    int find(int a, int[] c) {
        if (c[a] != a)
            c[a] = find(c[a], c);
        return c[a];
    }
}
