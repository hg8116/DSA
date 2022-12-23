// https://leetcode.com/problems/minimum-path-sum/

package MinimumPathSum64;

import java.util.Arrays;

public class MinimumPathSum {
    // Using recursion (TLE)
    /*
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return helper(n - 1, m - 1, grid);
    }

    int helper(int i, int j, int[][] grid) {
        if (i == 0 && j == 0)
            return grid[i][j];
        if (i < 0 || j < 0)
            return (int) 1e7;

        int up = grid[i][j] + helper(i - 1, j, grid);
        int left = grid[i][j] + helper(i, j - 1, grid);

        return Math.min(up, left);
    }
    */

    // Using memoization
    /*
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int[] x: dp)
            Arrays.fill(x, -1);

        return helper(n-1, m-1, grid);
    }

    int helper(int i, int j, int[][] grid){
        if(i == 0 && j == 0)
            return grid[i][j];
        if(i < 0 || j < 0)
            return (int)1e7;
        if(dp[i][j] != -1)
            return dp[i][j];

        int up = grid[i][j] + helper(i-1, j, grid);
        int left = grid[i][j] + helper(i, j-1, grid);

        return dp[i][j] = Math.min(up, left);
    }
    */

    // Using tabulation
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    if (i > 0) up += dp[i - 1][j];
                    else up += (int) 1e9;

                    int left = grid[i][j];
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int) 1e9;


                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
