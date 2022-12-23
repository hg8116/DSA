// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

package BestTimeToBuyAndSellStockIII123;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    // Using recursion (TLE)
    /*
    public int maxProfit(int[] prices) {
        return helper(0, 1, 2, prices);
    }

    int helper(int i, int buy, int cap, int[] arr) {
        if (i == arr.length)
            return 0;
        if (cap == 0)
            return 0;

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[i] + helper(i + 1, 0, cap, arr),
                    0 + helper(i + 1, 1, cap, arr));
        else
            profit = Math.max(arr[i] + helper(i + 1, 1, cap - 1, arr),
                    0 + helper(i + 1, 0, cap, arr));

        return profit;
    }
    */

    // Using memoization
    /*
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];
        for (int[][] arr : dp)
            for (int[] x : arr)
                Arrays.fill(x, -1);

        return helper(0, 1, 2, prices);
    }

    int helper(int i, int buy, int cap, int[] arr) {
        if (i == arr.length)
            return 0;
        if (cap == 0)
            return 0;
        if (dp[i][buy][cap] != -1)
            return dp[i][buy][cap];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[i] + helper(i + 1, 0, cap, arr),
                    0 + helper(i + 1, 1, cap, arr));
        else
            profit = Math.max(arr[i] + helper(i + 1, 1, cap - 1, arr),
                    0 + helper(i + 1, 0, cap, arr));

        return dp[i][buy][cap] = profit;
    }
    */

    // Using tabulation
    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1)
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i + 1][0][cap],
                                0 + dp[i + 1][1][cap]);
                    else
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i + 1][1][cap - 1],
                                0 + dp[i + 1][0][cap]);
                }
            }
        }
        return dp[0][1][2];
    }
    */

    // Space Optimization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] cur = new int[2][3];
        int[][] ahead = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1)
                        cur[buy][cap] = Math.max(-prices[i] + ahead[0][cap],
                                0 + ahead[1][cap]);
                    else
                        cur[buy][cap] = Math.max(prices[i] + ahead[1][cap - 1],
                                0 + ahead[0][cap]);
                }
                ahead = cur;
            }
        }
        return ahead[1][2];
    }
}
