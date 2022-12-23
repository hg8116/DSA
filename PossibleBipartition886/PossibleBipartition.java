// https://leetcode.com/problems/possible-bipartition/

package PossibleBipartition886;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] x : dislikes) {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1 && !dfs(i, color, adj))
                return false;
        }

        return true;
    }

    boolean dfs(int i, int[] color, List<List<Integer>> adj) {
        for (Integer it : adj.get(i)) {
            if (color[it] == -1) {
                color[it] = 1 - color[i];
                if (!dfs(it, color, adj))
                    return false;
            } else if (color[it] == color[i])
                return false;
        }

        return true;
    }
}
