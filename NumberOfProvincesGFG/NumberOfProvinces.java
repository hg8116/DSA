// https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces

package NumberOfProvincesGFG;

import java.util.ArrayList;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // Making adjacency list from adjacency matrix
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<Integer>());

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, adjList);
            }
        }

        return count;
    }

    static void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[i] = true;
        for (Integer it : adjList.get(i)) {
            if (vis[it] == false)
                dfs(it, vis, adjList);
        }
    }
}