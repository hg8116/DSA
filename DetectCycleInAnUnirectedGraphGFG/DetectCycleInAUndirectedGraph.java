// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

package DetectCycleInAnUnirectedGraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInAUndirectedGraph {
    public class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (vis[i] == false)
                if (checkBfs(i, vis, adj))
                    return true;
        }
        return false;
    }

    // Checking cycle using BFS
    public boolean checkBfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, -1));
        vis[i] = true;
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                } else if (par != it) return true;
            }
        }

        return false;
    }

    // Checking cycle using DFS
    public boolean checkDfs(int i, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        for (Integer it : adj.get(i)) {
            if (vis[it] == false) {
                if (checkDfs(it, i, vis, adj))
                    return true;

                else if (par != it)
                    return true;
            }

        }
        return false;
    }
}
