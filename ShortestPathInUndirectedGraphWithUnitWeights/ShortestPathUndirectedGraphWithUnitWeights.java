package ShortestPathInUndirectedGraphWithUnitWeights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraphWithUnitWeights {
    public void shortestPath(int V, int source, ArrayList<ArrayList<Integer>> adj){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[source] = 0;
        q.add(source);

        while(!q.isEmpty()){
            int node = q.poll();
            for (Integer it: adj.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i=0; i<V; i++){
            System.out.println(dist[i] + " ");
        }

    }
}
