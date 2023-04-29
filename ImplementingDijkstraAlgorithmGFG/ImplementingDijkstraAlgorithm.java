// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

package ImplementingDijkstraAlgorithmGFG;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.v;
            int wt = temp.wt;
            for (ArrayList<Integer> it : adj.get(node)) {
                int new_v = it.get(0);
                int new_wt = it.get(1);
                if (wt + new_wt < ans[new_v]) {
                    ans[new_v] = wt + new_wt;
                    pq.add(new Pair(new_v, wt + new_wt));
                }
            }
        }

        return ans;
    }
}
