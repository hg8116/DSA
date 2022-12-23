// https://leetcode.com/problems/minimum-falling-path-sum/

package MinimumFallingPathSum931;

import java.util.Arrays;

public class MinimumFallingPathSum {
    // Using recursion (TLE)
    /*
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = helper(n - 1, i, matrix);
        }

        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    int helper(int i, int j, int[][] mat) {
        if (i < 0 || j < 0 || j >= mat.length)
            return (int) 1e9;
        if (i == 0)
            return mat[i][j];

        int up = mat[i][j] + helper(i - 1, j, mat);
        int ul = mat[i][j] + helper(i - 1, j - 1, mat);
        int ur = mat[i][j] + helper(i - 1, j + 1, mat);
        return Math.min(up, Math.min(ul, ur));
    }
    */

    // Using memoization
    /*
    int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];

        for (int[] x : dp)
            Arrays.fill(x, -1);

        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            arr[i] = helper(n - 1, i, matrix);
        }

        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    int helper(int i, int j, int[][] mat) {
        if (i < 0 || j < 0 || j >= mat.length)
            return (int) 1e9;
        if (i == 0)
            return mat[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = mat[i][j] + helper(i - 1, j, mat);
        int ul = mat[i][j] + helper(i - 1, j - 1, mat);
        int ur = mat[i][j] + helper(i - 1, j + 1, mat);
        return dp[i][j] = Math.min(up, Math.min(ul, ur));
    }
    */

    // Using tabulation
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int u = matrix[i][j];
                if (i > 0) u += dp[i - 1][j];
                else u += (int) 1e9;

                int ul = matrix[i][j];
                if (j > 0 && i > 0) ul += dp[i - 1][j - 1];
                else ul += (int) 1e9;

                int ur = matrix[i][j];
                if (i > 0 && j < n - 1) ur += dp[i - 1][j + 1];
                else ur += (int) 1e9;

                dp[i][j] = Math.min(u, Math.min(ul, ur));
            }
        }

        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (min > dp[n - 1][i])
                min = dp[n - 1][i];
        }

        return min;
    }
}
