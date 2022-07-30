// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

package DFSOfGraphGFG;

import java.util.ArrayList;

public class DFSOfGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++){
            if(vis[i] == false)
                dfs(i, vis, adj, dfsList);
        }

        return dfsList;
    }

    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList){
        dfsList.add(node);
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(vis[it] == false)
                dfs(it, vis, adj, dfsList);
        }

    }
}
