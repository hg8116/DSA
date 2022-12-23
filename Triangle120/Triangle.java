// https://leetcode.com/problems/triangle/

package Triangle120;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    // Using recursion (TLE)
    /*
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, 0, triangle.size(), triangle);
    }

    int helper(int i, int j, int n, List<List<Integer>> list) {
        if (i == n - 1)
            return list.get(i).get(j);

        int d = list.get(i).get(j) + helper(i + 1, j, n, list);
        int dg = list.get(i).get(j) + helper(i + 1, j + 1, n, list);

        return Math.min(d, dg);
    }
    */

    // Using memoization
    /*
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return helper(0, 0, triangle.size(), triangle);
    }

    int helper(int i, int j, int n, List<List<Integer>> list) {
        if (i == n - 1)
            return list.get(i).get(j);
        if (dp[i][j] != -1)
            return dp[i][j];

        int d = list.get(i).get(j) + helper(i + 1, j, n, list);
        int dg = list.get(i).get(j) + helper(i + 1, j + 1, n, list);

        return dp[i][j] = Math.min(d, dg);
    }
    */

    // Using tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[][] dp = new int[n][m];

        for(int j=0; j<m; j++)
            dp[n-1][j] = triangle.get(n-1).get(j);
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(d, dg);
            }
        }

        return dp[0][0];
    }
}
