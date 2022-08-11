// https://leetcode.com/problems/critical-connections-in-a-network/

package CriticalConnectionsInANetwork1192;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        // Forming adjacency list
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0), b = connections.get(i).get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        int timer = 0;

        for(int i=0; i<n; i++){
            if(vis[i] == 0)
                findLink(i, -1, vis, tin, low, adj, ans, timer);
        }

        return ans;
    }

    void findLink(int node, int parent, int[] vis, int[] tin, int[] low, List<List<Integer>> adj, List<List<Integer>> ans, int timer){
        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for(Integer it: adj.get(node)){
            if (it == parent) continue;
            if(vis[it] == 0){
                findLink(node, parent, vis, tin, low, adj, ans, timer);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] > tin[node]){
                    List<Integer> link = new ArrayList<>();
                    link.add(it);
                    link.add(node);
                    ans.add(new ArrayList<>(node));
                }
            }
            else{
                low[node] = Math.min(low[it], tin[it]);
            }
        }
    }
}
