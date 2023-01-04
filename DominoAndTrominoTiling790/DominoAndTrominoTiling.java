// https://leetcode.com/problems/domino-and-tromino-tiling/

package DominoAndTrominoTiling790;

import java.util.Arrays;

public class DominoAndTrominoTiling {
    // Using memoization
    /*
    int mod = 1000000007;
    int[] dp;

    public int numTilings(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n);
    }

    int helper(int i) {
        if (i == 1 || i == 2)
            return i;
        if (dp[i] != -1)
            return dp[i];
        if (i == 3)
            return 5;

        return dp[i] = (2 * helper(i - 1) % mod + helper(i - 3) % mod) % mod;
    }
    */

    // Using tabulation
    public int numTilings(int n) {
        if (n == 1 || n == 2)
            return n;

        int mod = 1000000007;
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++)
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;

        return dp[n];
    }
}
