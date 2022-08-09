// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

package ImplementPrimsAlgorithmGFG;

import java.util.ArrayList;
import java.util.Arrays;

// TC - O((V + E) logV)

public class ImplementPrimsAlgorithm {
    static class Pair {
        int v, wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static void primsAlgo(ArrayList<ArrayList<Pair>> adj, int V){
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mst = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for(int i=0; i<V-1; i++){
            int min = Integer.MAX_VALUE, u = 0;
            for(int j = 0; j<V; j++){
                if(mst[j] == false && key[j] < min){
                    min = key[j];
                    u = j;
                }
            }
            mst[u] = true;

            for(Pair it: adj.get(u)){
                if(mst[it.v] == false && it.wt < key[it.v]){
                    parent[it.v] = u;
                    key[it.v] = it.wt;
                }
            }
        }
        for (int i=1; i<V; i++){
            System.out.println(parent[i] + " - " + i);
        }

    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Pair>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));

        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));

        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));

        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));

        adj.get(2).add(new Pair(4, 7));
        adj.get(4).add(new Pair(2, 7));

        primsAlgo(adj, n);
    }
}
