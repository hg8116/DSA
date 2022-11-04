package DynamicProgramming.Fibonacci;

import java.util.Arrays;

public class fibonacci {
    // Memoization
    // TC - O(n)
    // SC - O(n) + O(n)
    static int fibo(int n, int[] dp) {
        if (n <= 1)
            return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }

    // Converting to tabulation
    // TC - O(n)
    // SC - O(n)
    static int fibo2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Reducing SC even more
    static int fibo3(int n) {
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n, dp));
        System.out.println(fibo2(n));
        System.out.println(fibo3(n));
    }
}
