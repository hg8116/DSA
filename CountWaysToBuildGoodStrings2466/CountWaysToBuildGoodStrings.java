// https://leetcode.com/problems/count-ways-to-build-good-strings/

package CountWaysToBuildGoodStrings2466;

import java.util.Arrays;

public class CountWaysToBuildGoodStrings {
    int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);

        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + helper(i, zero, one, dp)) % MOD;
        }

        return ans;
    }

    int helper(int n, int zero, int one, int[] dp) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = (helper(n - zero, zero, one, dp) + helper(n - one, zero, one, dp)) % MOD;
    }
}
