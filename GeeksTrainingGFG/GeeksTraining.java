// https://practice.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training

package GeeksTrainingGFG;

import java.util.Arrays;

public class GeeksTraining {
    // Using recursion (TLE)
    /*
    public int maximumPoints(int points[][], int n) {
        return helper(n - 1, 3, points);
    }

    int helper(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, points[0][task]);
                }
            }
            return max;
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + helper(day - 1, task, points);
                max = Math.max(max, point);
            }
        }
        return max;
    }
    */

    // Using memoization
    /*
    int[][] dp;
    public int maximumPoints(int points[][],int n){
        dp = new int[n][4];
        for(int[] x: dp)
            Arrays.fill(x, -1);
        return helper(n-1, 3, points);
    }

    int helper(int day, int last, int[][] points){
        if(day == 0){
            int max = 0;
            for(int task = 0; task<3; task++){
                if(task != last){
                    max = Math.max(max, points[0][task]);
                }
            }
            return dp[day][last] = max;
        }

        if(dp[day][last] != -1)
            return dp[day][last];

        int max = 0;
        for(int task = 0; task<3; task++){
            if(task != last){
                int point = points[day][task] + helper(day-1, task, points);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }
    */

    // Using tabulation
    public int maximumPoints(int points[][], int n) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(dp[0][1], dp[0][2]);
        dp[0][1] = Math.max(dp[0][0], dp[0][2]);
        dp[0][2] = Math.max(dp[0][0], dp[0][1]);
        dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + points[day - 1][task];
                        dp[day][last] = Math.max(point, dp[day][last]);
                    }
                }
            }
        }

        return dp[n - 1][3];

    }

}
