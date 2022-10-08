import ShortestPathInDAGWithWeights.ShortestPathInDAG;

import java.util.*;

class test {
<<<<<<< HEAD
    public static void main(String[] args) {

=======
    static class Pair {
        int V, weight;

        Pair(int V, int weight) {
            this.V = V;
            this.weight = weight;
        }
    }

    static void shortestPath(int s, ArrayList<ArrayList<Integer>> adj, int V){
        Stack<Integer> stack = new Stack<>();

    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(0).add(new Pair(2, 3));
        adj.get(0).add(new Pair(3, 6));
        adj.get(0).add(new Pair(2, 2));
        adj.get(0).add(new Pair(5, 4));
        adj.get(0).add(new Pair(3, 1));
>>>>>>> a0301c79604e389f01efcdf6e5a675647e41aff4
    }
}