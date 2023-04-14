package LongestPalindromicSubsequence516;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length() + 1;
        int[][] dp = new int[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (s.charAt(i - 1) == s.charAt(len - 1 - j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[len - 1][len - 1];
    }
}
