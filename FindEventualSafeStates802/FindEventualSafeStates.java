// https://leetcode.com/problems/find-eventual-safe-states/

package FindEventualSafeStates802;

import java.util.*;

public class FindEventualSafeStates {
    // Using DFS
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] vis = new int[V];
        int[] dfsVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, dfsVis, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (dfsVis[i] == 0)
                ans.add(i);
        }

        return ans;
    }

    boolean dfs(int i, int[] vis, int[] dfsVis, List<List<Integer>> adj) {
        vis[i] = 1;
        dfsVis[i] = 1;
        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                if (dfs(it, vis, dfsVis, adj))
                    return true;
            } else if (dfsVis[it] == 1)
                return true;
        }
        dfsVis[i] = 0;
        return false;
    }

    // Using BFS
    public List<Integer> eventualSafeNodesBFS(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        int[] indegree = new int[V];

        for(int i=0; i<V; i++)
            adj.add(new ArrayList<>());

        // Reverse the directed edges of the graph
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(Integer it: adj.get(curr)){
                if(--indegree[it] == 0)
                    q.add(it);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
