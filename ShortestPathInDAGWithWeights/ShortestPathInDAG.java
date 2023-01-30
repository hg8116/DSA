package ShortestPathInDAGWithWeights;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDAG {
    static class Pair {
        int v, weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
}

    void topoligicalSortUtil(int node, Boolean[] visited, Stack stack, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = true;
        for (Pair it : adj.get(node)) {
            if (visited[it.getV()] == false) {
                topoligicalSortUtil(it.getV(), visited, stack, adj);
            }
        }

        stack.add(node);
    }

    void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N) {
        Stack<Integer> stack = new Stack<>();
        int dist[] = new int[N];

        Boolean[] visited = new Boolean[N];

        for (int i = 0; i < N; i++) {
            if (visited[i] == false)
                topoligicalSortUtil(i, visited, stack, adj);
        }

        for (int i = 0; i < N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (stack.empty() == false) {
            int node = stack.pop();
            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight();
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i] + " ");
        }
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
        ShortestPathInDAG obj = new ShortestPathInDAG();


    }
}
