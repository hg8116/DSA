// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

package BestTimeToBuyAndSellStockII122;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    // Using recursion (TLE)
    /*
    public int maxProfit(int[] prices) {
        return helper(0, 1, prices);
    }

    int helper(int i, int buy, int[] prices) {
        if (i == prices.length)
            return 0;

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-prices[i] + helper(i + 1, 0, prices),
                    0 + helper(i + 1, 1, prices));
        else
            profit = Math.max(prices[i] + helper(i + 1, 1, prices),
                    0 + helper(i + 1, 0, prices));

        return profit;
    }
    */

    // Using memoization
    /*
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return helper(0, 1, prices);
    }

    int helper(int i, int buy, int[] prices) {
        if (i == prices.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-prices[i] + helper(i + 1, 0, prices),
                    0 + helper(i + 1, 1, prices));
        else
            profit = Math.max(prices[i] + helper(i + 1, 1, prices),
                    0 + helper(i + 1, 0, prices));

        return dp[i][buy] = profit;
    }
    */

    // Using tabulation
    /*
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1)
                    profit = Math.max(-prices[i] + dp[i + 1][0],
                            0 + dp[i + 1][1]);
                else
                    profit = Math.max(prices[i] + dp[i + 1][1],
                            0 + dp[i + 1][0]);
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
    */

    // Space optimization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy = 0, aheadBuy = 0, curNotBuy, curBuy;

        for (int i = n - 1; i >= 0; i--) {
            curNotBuy = Math.max(prices[i] + aheadBuy,
                    0 + aheadNotBuy);
            curBuy = Math.max(-prices[i] + aheadNotBuy,
                    0 + aheadBuy);

            aheadNotBuy = curNotBuy;
            aheadBuy = curBuy;
        }

        return aheadBuy;
    }
}
