// https://leetcode.com/problems/is-graph-bipartite/

package IsGraphBipartite785;

import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, color, graph))
                    return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int[] color, int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (i == node) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (color[graph[i][j]] == -1) {
                        color[graph[i][j]] = 1 - color[node];
                        if (!dfs(graph[i][j], color, graph))
                            return false;
                    } else if (color[graph[i][j]] == color[node])
                        return false;
                }
            }
        }
        return true;
    }
}
