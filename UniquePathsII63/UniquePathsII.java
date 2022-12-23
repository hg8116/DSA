// https://leetcode.com/problems/unique-paths-ii/

package UniquePathsII63;

import java.util.Arrays;

public class UniquePathsII {
    // Using recursion (TLE)
    /*
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length;
        int j = obstacleGrid[0].length;

        return helper(i - 1, j - 1, obstacleGrid);
    }

    int helper(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        return helper(i - 1, j, grid) + helper(i, j - 1, grid);
    }
    */

    // Using memoization
    /*
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length;
        int j = obstacleGrid[0].length;

        dp = new int[i][j];
        for(int[] x: dp)
            Arrays.fill(x, -1);

        return helper(i-1, j-1, obstacleGrid);
    }

    int helper(int i, int j, int[][] grid){
        if(i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;
        if(i == 0 && j == 0)
            return 1;
        if(i < 0 || j < 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = helper(i-1, j, grid) + helper(i, j-1, grid);
    }
    */

    // Using tabulation
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0)
                    dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
