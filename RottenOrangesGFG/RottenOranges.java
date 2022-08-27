// https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges

package RottenOrangesGFG;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public class Info {
        int x, y, t;

        public Info(int _x, int _y, int _t) {
            x = _x;
            y = _y;
            t = _y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Info> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Info(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, -1, 0, +1};
        int tm = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int t = q.peek().t;
            tm = Math.max(tm, t);
            for (int i = 0; i < 4; i++) {
                int nrow = x + drow[i];
                int ncol = y + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.add(new Info(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return tm;

    }

}
