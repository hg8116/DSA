// https://leetcode.com/problems/path-with-minimum-effort/

package PathWithMinimumEffort1631;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {

    // Using BFS and Binary Search
    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 1000001;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (bfs(heights, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }

        return l;
    }

    boolean bfs(int[][] heights, int limit) {
        int n = heights.length;
        int m = heights[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] vis = new boolean[n][m];

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            if (x == n - 1 && y == m - 1)
                return true;

            for (int i = 0; i < 4; i++) {
                int nrow = x + drow[i];
                int ncol = y + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == false) {
                    if (Math.abs(heights[x][y] - heights[nrow][ncol]) <= limit) {
                        q.add(new int[]{nrow, ncol});
                        vis[nrow][ncol] = true;
                    }
                }
            }
        }

        return false;
    }

    // Using Dijkstra's Algo
    public int minimumEffortPath2(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for (int[] x : dist)
            Arrays.fill(x, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == n - 1 && y == m - 1)
                break;
            for (int i = 0; i < 4; i++) {
                int nrow = x + drow[i];
                int ncol = y + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int currDist = Math.max(curr[2], Math.abs(heights[x][y] - heights[nrow][ncol]));
                    if (currDist < dist[nrow][ncol]) {
                        pq.add(new int[]{nrow, ncol, currDist});
                        dist[nrow][ncol] = currDist;
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}