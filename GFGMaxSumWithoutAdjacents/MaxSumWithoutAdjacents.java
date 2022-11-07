// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-without-adjacents

package GFGMaxSumWithoutAdjacents;

import java.util.Arrays;

public class MaxSumWithoutAdjacents {
    /*
    Just using recursion (will give TLE)
    int findMaxSum(int[] arr, int n) {
        return helper(n - 1, arr);
    }

    int helper(int n, int[] arr) {
        if (n == 0) return arr[n];
        if (n < 0) return 0;

        int pick = arr[n] + helper(n - 2, arr);
        int notPick = 0 + helper(n - 1, arr);

        return Math.max(pick, notPick);
    }
    */
    /*
    Using memoization
    int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, arr, dp);
    }

    int helper(int n, int[] arr, int[] dp){
        if(n == 0) return arr[n];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int pick = arr[n] + helper(n-2, arr, dp);
        int notPick = helper(n-1, arr, dp);

        return dp[n] = Math.max(pick, notPick);
    }
    */
    /*
    Using tabulation
    int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = arr[0];
        for(int i=1; i<n; i++){

            int pick = arr[i];
            if(i > 1)
                pick += dp[i-2];
            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n-1];
    }
    */
    // Space optimization
    int findMaxSum(int arr[], int n) {
        int prev = arr[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (n > 1)
                pick += prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
