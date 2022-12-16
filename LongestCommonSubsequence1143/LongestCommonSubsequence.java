// https://leetcode.com/problems/longest-common-subsequence/

package LongestCommonSubsequence1143;

import java.util.Arrays;

public class LongestCommonSubsequence {
    /*
    // Using recursion (TLE)
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, 0, 0);
    }

    int helper(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length())
            return 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            return helper(text1, text2, i + 1, j + 1) + 1;
        }
        int l = helper(text1, text2, i + 1, j);
        int r = helper(text1, text2, i, j + 1);

        return Math.max(l, r);
    }
    */

    /*
    // Using recursion + memoization
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[1001][1001];
        for(int[] x: dp)
            Arrays.fill(x, -1);
        return helper(text1, text2, 0, 0);
    }

    int helper(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = helper(text1, text2, i + 1, j + 1) + 1;
        }
        int l = helper(text1, text2, i + 1, j);
        int r = helper(text1, text2, i, j + 1);

        return dp[i][j] = Math.max(l, r);
    }
    */

    // Using tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length() + 1;
        int len2 = text2.length() + 1;

        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        for (int x[] : dp)
            System.out.println(Arrays.toString(x));

        return dp[len1 - 1][len2 - 1];
    }
}
