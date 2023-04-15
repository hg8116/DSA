// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/

package MaximumValueOfKCoinsFromPiles2218;

import java.util.List;

public class MaximumValueOfKCoinsFromPiles {
    Integer[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new Integer[piles.size() + 1][k + 1];
        return helper(0, k, piles);
    }

    int helper(int i, int k, List<List<Integer>> piles) {
        if (i >= piles.size() || k == 0)
            return 0;

        if (dp[i][k] != null)
            return dp[i][k];

        int notTaken = helper(i + 1, k, piles);

        int taken = 0;
        int sum = 0;
        for (int j = 0; j < Math.min(k, piles.get(i).size()); j++) {
            sum += piles.get(i).get(j);
            taken = Math.max(taken, sum + helper(i + 1, k - (j + 1), piles));
        }

        return dp[i][k] = Math.max(taken, notTaken);
    }
}
