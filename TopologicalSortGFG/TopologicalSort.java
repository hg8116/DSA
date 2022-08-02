// https://practice.geeksforgeeks.org/problems/topological-sort/1

package TopologicalSortGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Only possible in case of DAG (Directed Acyclic Graphs)

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                topoDfs(i, vis, stack, adj);
            }
        }

        int i=0;
        int[] ans = new int[V];

        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }

        return ans;
    }


    // Using DFS
    static void topoDfs(int i, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj){
        vis[i] = 1;
        for(Integer it: adj.get(i)){
            if(vis[it] == 0)
                topoDfs(it, vis, stack, adj);
        }

        stack.push(i);
    }

    // Using BFS (Kahn's Algo)
    static int[] topoSortBfs(int V, ArrayList<ArrayList<Integer>> adj){
        int[] topo = new int[V];
        int[] indegree = new int[V];

        for(int i=0; i<V; i++){
            for(Integer it: adj.get(i))
                indegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int i = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            topo[i++] = node;
            for (Integer it: adj.get(node))
                if(--indegree[it] == 0)
                    q.add(it);
        }

        return topo;
    }

}
