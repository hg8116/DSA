// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

package BFSOfGraphGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOfGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            for(int it: adj.get(node)){
                if(vis[it] == false){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }

        return bfs;
    }
}
