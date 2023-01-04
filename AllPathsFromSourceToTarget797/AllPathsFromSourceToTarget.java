// https://leetcode.com/problems/all-paths-from-source-to-target/

package AllPathsFromSourceToTarget797;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    // Using DFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, graph.length - 1, curr, ans, graph);

        return ans;
    }

    void dfs(int i, int dist, List<Integer> curr, List<List<Integer>> ans, int[][] adj) {
        if (i == dist) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int x : adj[i]) {
            curr.add(x);
            dfs(x, dist, curr, ans, adj);
            curr.remove(curr.size() - 1);
        }
    }
}
