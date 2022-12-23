// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package BestTimeToBuyAndSellStock121;

public class BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int min = prices[0];

            for (int i = 1; i < prices.length; i++) {
                int cost = prices[i] - min;
                profit = Math.max(cost, profit);
                min = Math.min(prices[i], min);
            }

            return profit;
        }
    }
}
