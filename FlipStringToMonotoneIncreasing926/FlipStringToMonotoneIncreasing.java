// https://leetcode.com/problems/flip-string-to-monotone-increasing/

package FlipStringToMonotoneIncreasing926;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {
    // Using recursion (TLE)
    /*
    public int minFlipsMonoIncr(String s) {
        return helper(s, 0, 0);
    }

    int helper(String s, int curr, int prev){
        if(curr >= s.length())
            return 0;

        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;

        if(s.charAt(curr) == '0'){
            if(prev == 0){
                flip = 1 + helper(s, curr+1, 1);
                notFlip = 0 + helper(s, curr+1, 0);
            }
            else{
                flip = 1 + helper(s, curr+1, 1);
            }
        }
        else{
            if(prev == 0){
                flip = 1 + helper(s, curr+1, 0);
                notFlip = 0 + helper(s, curr+1, 1);
            }
            else{
                notFlip = 0 + helper(s, curr+1, 1);
            }
        }

        return Math.min(flip, notFlip);
    }
    */

    // Using memoization
    class Solution {
        int[][] dp;

        public int minFlipsMonoIncr(String s) {
            dp = new int[s.length()][2];
            for (int[] x : dp) {
                Arrays.fill(x, -1);
            }
            return helper(s, 0, 0);
        }

        int helper(String s, int curr, int prev) {
            if (curr >= s.length())
                return 0;

            if (dp[curr][prev] != -1)
                return dp[curr][prev];

            int flip = Integer.MAX_VALUE;
            int notFlip = Integer.MAX_VALUE;

            if (s.charAt(curr) == '0') {
                if (prev == 0) {
                    flip = 1 + helper(s, curr + 1, 1);
                    notFlip = 0 + helper(s, curr + 1, 0);
                } else {
                    flip = 1 + helper(s, curr + 1, 1);
                }
            } else {
                if (prev == 0) {
                    flip = 1 + helper(s, curr + 1, 0);
                    notFlip = 0 + helper(s, curr + 1, 1);
                } else {
                    notFlip = 0 + helper(s, curr + 1, 1);
                }
            }

            return dp[curr][prev] = Math.min(flip, notFlip);
        }
    }
}
