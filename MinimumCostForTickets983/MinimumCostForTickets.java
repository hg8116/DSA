//  https://leetcode.com/problems/minimum-cost-for-tickets/description/

package MinimumCostForTickets983;

import java.util.Arrays;

public class MinimumCostForTickets {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days[days.length-1] + 1];
        Arrays.fill(dp, -1);
        return helper(days, costs, days.length-1);
    }

    int helper(int[] days, int[] costs, int i){
        if(i < 0)
            return 0;
        if(dp[days[i]] != -1)
            return dp[days[i]];

        int day = costs[0] + helper(days, costs, i-1);
        int weekInd = upperBound(days, days[i] - 7) - 1;
        int week = costs[1] + helper(days, costs, weekInd);
        int monthInd = upperBound(days, days[i]-30) - 1;
        int month = costs[2] + helper(days, costs, monthInd);

        return dp[days[i]] = Math.min(Math.min(week, month), day);
    }

    int upperBound(int[] arr, int x){
        int start = 0, end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] <= x){
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return start;
    }
}
