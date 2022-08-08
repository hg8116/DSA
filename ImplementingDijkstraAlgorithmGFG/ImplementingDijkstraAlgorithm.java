// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

package ImplementingDijkstraAlgorithmGFG;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ImplementingDijkstraAlgorithm {
    static class Pair implements Comparable<Pair> {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair ob) {
            return this.wt - ob.wt;
        }

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] dist = new int[V];
        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            if (vis[node.v] == false)
                vis[node.v] = true;
            else
                continue;

            dist[node.v] = node.wt;
            for (ArrayList<Integer> it : adj.get(node.v)) {
                if (vis[it.get(0)] == false)
                    pq.add(new Pair(it.get(0), it.get(1) + node.wt));
            }

        }
        return dist;
    }
}
