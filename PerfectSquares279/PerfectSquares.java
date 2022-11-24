// https://leetcode.com/problems/perfect-squares/

package PerfectSquares279;

public class PerfectSquares {
    /*
    // Using recursion (TLE)
    public int numSquares(int n) {
        return helper(n);
    }

    int helper(int n) {
        if (n <= 3)
            return n;
        int ans = n;
        for (int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + helper(n - i * i));
        }

        return ans;
    }
    */

    /*
    // Using memoization
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    int helper(int n, int[] dp) {
        if (n <= 3)
            return n;
        if (dp[n] != 0)
            return dp[n];
        int min = n;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, helper(n - i * i, dp));
        }
        dp[n] = min;
        return min;
    }
    */

    /*
    // Using tabulation
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }
    */

    // Using Legendre's 3 square theorem
    public int numSquares(int n) {
        if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n)))
            return 1;
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        for (int i = 1; i * i <= n; i++) {
            int base = (int) Math.sqrt(n - i * i);
            if (base * base == (n - i * i))
                return 2;
        }

        return 3;
    }
}
