// https://leetcode.com/problems/climbing-stairs/

package DynamicProgramming.ClimbingStairs70;

import java.util.Arrays;

public class ClimbingStairs {
    /*
    Just using recursion (will give TLE)
    static int climbStairs(int n) {
        if (n <= 1)
            return 1;

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;
    }
    */

    /*
    Using Memoization
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    int helper(int n, int[] dp){
        if(n <= 1)
            return 1;
        if(dp[n] != -1) return dp[n];
        int left = helper(n-1, dp);
        int right = helper(n-2, dp);

        return dp[n] = left + right;
    }
     */
    /*
    Using Table
    public int climbStairs(int n) {
        if(n <= 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    */
    // Even more optimization
    public int climbStairs(int n) {
        if(n <= 1)
            return 1;
        int prev2 = 1, prev = 2;
        for(int i=3; i<=n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}
