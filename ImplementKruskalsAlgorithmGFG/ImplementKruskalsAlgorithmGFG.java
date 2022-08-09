// https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/

package ImplementKruskalsAlgorithmGFG;

import Test.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ImplementKruskalsAlgorithmGFG {
    static class Node {
        int u, v, wt;

        Node(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWt() {
            return wt;
        }
    }

    static class SortComparator implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.wt - n2.wt;
        }
    }

    static int findPar(int u, int parent[]) {
        if (u == parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    static void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static void kruskalsAglo(ArrayList<Node> adj, int N){
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N];
        int rank[] = new int[N];

        for(int i=0; i<N; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<Node> mst = new ArrayList<>();
        for(Node it: adj){
            if(findPar(it.getU(), parent) != findPar(it.getV(), parent)){
                costMst += it.getWt();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }

        System.out.println(costMst);
        for(Node it: mst){
            System.out.println(it.getU() + " - " + it.getV());
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));

        kruskalsAglo(adj, n);

    }
}
