// https://leetcode.com/problems/01-matrix/
package Zero1Matrix542;

import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }

        int steps = 1;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, -1, 0, +1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = temp[0] + drow[j];
                    int y = temp[1] + dcol[j];
                    if (x >= 0 && x < n && y >= 0 && y < m && vis[x][y] == 0) {
                        vis[x][y] = 1;
                        mat[x][y] = steps;
                        q.add(new int[]{x, y});
                    }
                }
            }
            steps++;
        }
        return mat;
    }
}