// https://leetcode.com/problems/unique-paths/

package UniquePaths62;

import java.util.Arrays;

public class UniquePaths {
    // Using recursion (TLE)
    /*
    public int uniquePaths(int m, int n) {
        return helper(m-1, n-1);
    }

    int helper(int i, int j){
        if(i == 0 && j == 0)
            return 1;
        if(i < 0 || j < 0)
            return 0;

        return helper(i-1, j) + helper(i, j-1);
    }
    */

    // Using memoization
    /*
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return helper(m - 1, n - 1);
    }

    int helper(int i, int j) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = helper(i - 1, j) + helper(i, j - 1);
    }
    */

    // Using tabulation
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];

        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else{
                    int up = 0, left = 0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
