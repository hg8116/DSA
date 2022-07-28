package Graph;

import java.util.ArrayList;

/*
    1 -- 2 -- 4    3 -- 5
         |    |  component 2
         7 -- 6
       component 1
*/

// Time Complexity - O(N+E)
// Space Complexity - O(N+E) + O(N) + O(N)

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1];

        for(int i=1; i<=V; i++){
            if(vis[i] == false){
                dfs(i, vis, adj, storeDfs);
            }
        }

        return storeDfs;
    }

    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs){
        storeDfs.add(node);
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(vis[it] == false){
                dfs(it, vis, adj, storeDfs);
            }
        }
    }
}
