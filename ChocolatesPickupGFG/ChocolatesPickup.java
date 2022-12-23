// https://practice.geeksforgeeks.org/problems/chocolates-pickup/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=chocolates-pickup

package ChocolatesPickupGFG;

import java.util.Arrays;

public class ChocolatesPickup {
    // Using recursion (TLE)
    /*
    public int solve(int n, int m, int grid[][]) {
        return helper(0, 0, m - 1, n, m, grid);
    }

    int helper(int i, int j1, int j2, int n, int m, int[][] grid) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return (int) -1e9;

        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        int ans = Integer.MIN_VALUE;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int curr = 0;
                if (j1 == j2)
                    curr = grid[i][j1];
                else
                    curr = grid[i][j1] + grid[i][j2];
                curr += helper(i + 1, j1 + x, j2 + y, n, m, grid);
                ans = Math.max(curr, ans);
            }
        }

        return ans;
    }
    */

    // Using memoization
    /*
    int[][][] dp;
    public int solve(int n, int m, int grid[][]){
        dp = new int[n][m][m];
        for(int[][] mat: dp){
            for(int[] arr: mat){
                Arrays.fill(arr, -1);
            }
        }
        return helper(0, 0, m-1, n, m, grid);
    }

    int helper(int i, int j1, int j2, int n, int m, int[][] grid){
        if(j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return (int) -1e9;

        if(i == n-1){
            if(j1 == j2)
                return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int ans = Integer.MIN_VALUE;
        for(int x=-1; x<=1; x++){
            for(int y=-1; y<=1; y++){
                int curr = 0;
                if(j1 == j2)
                    curr = grid[i][j1];
                else
                    curr = grid[i][j1] + grid[i][j2];
                curr += helper(i+1, j1+x, j2+y, n, m, grid);
                ans = Math.max(curr, ans);
            }
        }

        return dp[i][j1][j2] = ans;
    }
    */

    // Using tabulation
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int) -1e8;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int val = 0;
                            if (j1 == j2)
                                val = grid[i][j1];
                            else
                                val = grid[i][j1] + grid[i][j2];
                            if (j1 + x >= 0 && j1 + x < m && j2 + y >= 0 && j2 + y < m)
                                val += dp[i + 1][j1 + x][j2 + y];
                            else
                                val += (int) -1e8;
                            maxi = Math.max(maxi, val);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}
