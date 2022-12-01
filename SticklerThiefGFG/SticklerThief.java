// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=stickler-theif-

package SticklerThiefGFG;

import java.util.Arrays;

public class SticklerThief {
    /*
    // Recursion (TLE)
    public int FindMaxSum(int arr[], int n)
    {
        return helper(n-1, arr);
    }

    int helper(int n, int[] arr){
        if(n == 0) return arr[n];
        if(n < 0) return 0;

        int pick = arr[n] + helper(n-2, arr);
        int notPick = 0 + helper(n-1, arr);

        return Math.max(pick, notPick);
    }
    */

    /*
    // Memoization
    public int FindMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, arr, dp);
    }

    int helper(int n, int[] arr, int[] dp) {
        if (n == 0) return arr[n];
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];

        int pick = arr[n] + helper(n - 2, arr, dp);
        int notPick = 0 + helper(n - 1, arr, dp);

        return Math.max(pick, notPick);
    }
    */

    // Tabulation
    public int FindMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick = arr[i] + dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}
