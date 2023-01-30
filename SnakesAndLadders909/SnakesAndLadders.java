package SnakesAndLadders909;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n * n + 1];

        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            for (int size = q.size(); size > 0; size--) {
                int curr = q.poll();
                if (vis[curr])
                    continue;
                vis[curr] = true;
                if (curr == n * n)
                    return ans - 1;
                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    int val = findVal(next, board);
                    if (val > 0)
                        next = val;
                    if (!vis[next])
                        q.add(next);
                }
            }
        }
        return -1;
    }

    int findVal(int num, int[][] board) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = (r % 2 == 0) ? num - 1 - r * n : n + r * n - num;

        return board[x][y];
    }
}
