// https://leetcode.com/problems/as-far-from-land-as-possible/description/

package AsFarFromLandAsPossible1162;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    class Pair<T, I> {
        T p1;
        I p2;

        Pair(T p1, I p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        T getKey() {
            return p1;
        }

        I getValue() {
            return p2;
        }

    }

    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = grid[i][j];
                if (grid[i][j] == 1)
                    q.add(new Pair(i, j));
            }
        }

        int dist = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> temp = q.poll();
                for (int[] d : dir) {
                    int x = d[0] + temp.getKey();
                    int y = d[1] + temp.getValue();
                    if (x >= 0 && y >= 0 && x < n && y < m && vis[x][y] == 0) {
                        vis[x][y] = 1;
                        q.add(new Pair(x, y));
                    }
                }
            }
            dist++;
        }

        return dist == 0 ? -1 : dist;
    }
}

