// https://practice.geeksforgeeks.org/problems/bipartite-graph/1

package BipartiteGraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V; i++){
            if(color[i] == -1)
                if(!checkBfs(i, color, adj))
                    return false;
        }

        return true;
    }

    // Using BFS
    public boolean checkBfs(int i, int[] color, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;

        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer it: adj.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                else if(color[it] == color[node])
                    return false;
            }
        }

        return true;
    }


    // Using DFS
    public boolean checkDfs(int i, int[] color, ArrayList<ArrayList<Integer>> adj){
        for(Integer it: adj.get(i)){
            if(color[it] == -1){
                color[it] = 1 - color[i];
                if (!checkDfs(it, color, adj))
                    return false;
            }
            else if(color[it] == color[i])
                return false;
        }

        return true;
    }
}
