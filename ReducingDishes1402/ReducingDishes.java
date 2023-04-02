// https://leetcode.com/problems/reducing-dishes/description/

package ReducingDishes1402;

import java.util.Arrays;

public class ReducingDishes {
    int[][] dp;

    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        dp = new int[n + 1][n + 1];
        for (int[] x : dp)
            Arrays.fill(x, -1);
        return helper(satisfaction, 0, 1);
    }

    int helper(int[] satisfaction, int curr, int count) {
        if (curr >= satisfaction.length)
            return 0;
        if (dp[curr][count] != -1)
            return dp[curr][count];

        int taken = satisfaction[curr] * count + helper(satisfaction, curr + 1, count + 1);
        int notTaken = 0 + helper(satisfaction, curr + 1, count);

        return dp[curr][count] = Math.max(taken, notTaken);
    }
}
