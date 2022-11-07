// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0

package CSFrogJump;

public class FrogJump {
    /*
    Using recursion only (will give TLE)
    static int helper(int n, int[] heights){
        if(n == 0)
            return 0;

        int left = helper(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = helper(n-2, heights) + Math.abs(heights[n] - heights[n-2]);

        return Math.min(left, right);
    }

    public static int frogJump(int n, int heights[]) {
        return helper(n-1, heights, dp);
    }
     */
    /*
    Using memoization
    static int helper(int n, int[] heights, int[] dp){
        if(n == 0)
            return 0;

        if(dp[n] != -1) return dp[n];
        int left = helper(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = helper(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);

        return dp[n] = Math.min(left, right);
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n-1, heights, dp);
    }
    */
    /*
    Using tabulation
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1)
                ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(fs, ss);
        }

        return dp[n-1];
    }
    */
    // Space optimization
    public static int frogJump(int n, int heights[]) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(heights[i] - heights[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(fs, ss);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
