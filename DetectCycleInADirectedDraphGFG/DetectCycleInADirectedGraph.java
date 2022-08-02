// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package DetectCycleInADirectedDraphGFG;

import java.util.ArrayList;

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
    public boolean checkDfs(int i, int[] vis, int[] dfsVis, ArrayList<ArrayList<Integer>> adj){
        vis[i] = 1;
        dfsVis[i] = 1;

        for(Integer it: adj.get(i)){
            if(vis[it] == 0){
                if (checkDfs(it, vis, dfsVis, adj))
                    return true;
            }
            else if(dfsVis[it] == 1)
                return true;
        }

        dfsVis[i] = 0;
        return false;
    }
}
