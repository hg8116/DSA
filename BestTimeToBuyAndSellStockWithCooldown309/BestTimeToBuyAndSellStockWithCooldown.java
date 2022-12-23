// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

package BestTimeToBuyAndSellStockWithCooldown309;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    // Using memoization
    /*
    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for (int[] x : dp)
            Arrays.fill(x, -1);

        return helper(0, 1, prices);
    }

    int helper(int i, int buy, int[] arr) {
        if (i >= arr.length)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;
        if (buy == 1)
            profit = Math.max(-arr[i] + helper(i + 1, 0, arr),
                    0 + helper(i + 1, 1, arr));
        else
            profit = Math.max(arr[i] + helper(i + 2, 1, arr),
                    0 + helper(i + 1, 0, arr));

        return dp[i][buy] = profit;
    }
    */

    // Using tabulation
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int i=n-1; i>=0; i--){
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0],
                    0 + dp[i+1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i+2][1],
                    0 + dp[i+1][0]);
        }
        return dp[0][1];
    }
}
