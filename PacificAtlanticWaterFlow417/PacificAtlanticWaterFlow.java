// https://leetcode.com/problems/pacific-atlantic-water-flow/

package PacificAtlanticWaterFlow417;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = heights.length;
        int m = heights[0].length;

        int[][] visPac = new int[n][m];
        int[][] visAtl = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (visPac[0][j] == 0)
                dfs(0, j, visPac, heights);
            if (visAtl[n - 1][j] == 0)
                dfs(n - 1, j, visAtl, heights);
        }

        for (int i = 0; i < n; i++) {
            if (visPac[i][0] == 0)
                dfs(i, 0, visPac, heights);
            if (visAtl[i][m - 1] == 0)
                dfs(i, m - 1, visAtl, heights);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visPac[i][j] == 1 && visAtl[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    int[] drow = {-1, 0, +1, 0};
    int[] dcol = {0, -1, 0, +1};

    void dfs(int i, int j, int[][] vis, int[][] heights) {
        vis[i][j] = 1;
        for (int x = 0; x < 4; x++) {
            int nrow = i + drow[x];
            int ncol = j + dcol[x];
            if (nrow >= 0 && ncol >= 0 && nrow < heights.length && ncol < heights[0].length && heights[nrow][ncol] >= heights[i][j] && vis[nrow][ncol] != 1) {
                dfs(nrow, ncol, vis, heights);
            }
        }
    }
}
