package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    1 -- 2 -- 4    3 -- 5
         |    |  component 2
         7 -- 6
       component 1
*/

// Time Complexity - O(N+E)
// Space Complexity - O(N+E) + O(N) + O(N)

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);

                    for (Integer it : adj.get(node)) {
                        if (vis[it] == false) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
