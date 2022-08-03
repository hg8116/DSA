// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package DetectCycleInADirectedDraphGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] dfsVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                if (checkDfs(i, vis, dfsVis, adj))
                    return true;
        }

        return false;
    }


    // Using DFS
    // Time Complexity - O(N+E)
    // Space Complexity - O(N^2)
    public boolean checkDfs(int i, int[] vis, int[] dfsVis, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;
        dfsVis[i] = 1;

        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                if (checkDfs(it, vis, dfsVis, adj))
                    return true;
            } else if (dfsVis[it] == 1)
                return true;
        }

        dfsVis[i] = 0;
        return false;
    }

    // Using BFS (Kahn's Algo)
    public boolean isCyclicBfs(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (Integer it : adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (Integer it : adj.get(node)) {
                if (--indegree[it] == 0)
                    q.add(it);
            }
        }

        if (count == V) return false;
        return true;
    }
}
