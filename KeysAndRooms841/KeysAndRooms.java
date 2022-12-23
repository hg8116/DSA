// https://leetcode.com/problems/keys-and-rooms/

package KeysAndRooms841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    // Using BFS
    /*
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            vis[node] = true;
            for (Integer it : rooms.get(node)) {
                if (vis[it] == false)
                    q.add(it);
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == false)
                return false;
        }

        return true;
    }
    */

    // Using DFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

        vis[0] = true;
        dfs(0, vis, rooms);
        for (boolean x : vis) {
            if (!x)
                return false;
        }

        return true;
    }

    void dfs(int i, boolean[] vis, List<List<Integer>> adj) {
        vis[i] = true;
        for (Integer it : adj.get(i)) {
            if (!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
}
