// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

package BestTimeToBuyAndSellStockWithTransactionFee714;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    // Using memoization
    /*
    int[][] dp;

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for (int[] x : dp)
            Arrays.fill(x, -1);

        return helper(0, 1, prices, fee);
    }

    int helper(int i, int buy, int[] arr, int fee) {
        if (i == arr.length)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[i] + helper(i + 1, 0, arr, fee),
                    0 + helper(i + 1, 1, arr, fee));
        else
            profit = Math.max(arr[i] - fee + helper(i + 1, 1, arr, fee),
                    0 + helper(i + 1, 0, arr, fee));

        return dp[i][buy] = profit;
    }
    */

    // Using tabulation
    /*
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0],
                    0 + dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] - fee + dp[i + 1][1],
                    0 + dp[i + 1][0]);
        }

        return dp[0][1];
    }
    */

    // Space Optimization
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            cur[1] = Math.max(-prices[i] + ahead[0],
                    0 + ahead[1]);
            cur[0] = Math.max(prices[i] - fee + ahead[1],
                    0 + ahead[0]);
            ahead = cur;
        }

        return ahead[1];
    }
}
