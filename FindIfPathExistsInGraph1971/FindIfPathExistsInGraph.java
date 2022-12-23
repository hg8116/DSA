// https://leetcode.com/problems/find-if-path-exists-in-graph/

package FindIfPathExistsInGraph1971;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (int[] x : edges) {
            list.get(x[0]).add(x[1]);
            list.get(x[1]).add(x[0]);
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int i = q.poll();
            vis[i] = true;
            if (i == destination)
                return true;
            for (Integer it : list.get(i)) {
                if (vis[it] == false)
                    q.add(it);
            }
        }

        return false;
    }
}
