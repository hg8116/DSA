// https://leetcode.com/problems/shortest-path-in-binary-matrix/

package ShortestPathInBinaryMatrix1091;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public class Pair {
        int x, y, count;

        Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));

        int[] drow = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dcol = {0, -1, 0, 1, -1, 1, -1, 1};

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair curr = q.poll();
                int x = curr.x;
                int y = curr.y;
                int count = curr.count;
                if (x == n - 1 && y == m - 1)
                    return count;
                for (int i = 0; i < 8; i++) {
                    int nrow = x + drow[i];
                    int ncol = y + dcol[i];
                    if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 0) {
                        q.add(new Pair(nrow, ncol, count + 1));
                        grid[nrow][ncol] = 1;
                    }
                }
            }
            return -1;
        }
    }
}