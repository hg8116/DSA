import java.util.*;

class test {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                adj.get(graph[i][j]).add(i);
            }
        }

        System.out.println(adj);

        int[] vis = new int[V];
        int[] dfsVis = new int[V];
        int[] isCycle = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, dfsVis, adj)) {
                    isCycle[i] = 1;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isCycle[i] == 0)
                ans.add(i);
        }

        return ans;
    }

    static boolean dfs(int i, int[] vis, int[] dfsVis, List<List<Integer>> adj) {
        vis[i] = 1;
        dfsVis[i] = 1;
        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                if (dfs(it, vis, dfsVis, adj))
                    return true;
            } else if (dfsVis[it] == 1)
                return true;
        }

        dfsVis[i] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }
}