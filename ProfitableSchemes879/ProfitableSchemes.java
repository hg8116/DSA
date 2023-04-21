// https://leetcode.com/problems/profitable-schemes/description/

package ProfitableSchemes879;

public class ProfitableSchemes {
    int MOD = 1000_000_007;
    Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[group.length][n+1][minProfit+1];
        return helper(n, minProfit, group, profit, 0, 0);
    }

    int helper(int n, int min, int[] group, int[] profit, int i, int count){
        if(min <= 0 && i == group.length && count <= n)
            return 1;
        if(i >= group.length || count > n)
            return 0;

        if(min < 0)
            min = 0;

        if(dp[i][count][min] != null)
            return dp[i][count][min];

        int pick = helper(n, min-profit[i], group, profit, i+1, count + group[i]);
        int notPick = helper(n, min, group, profit, i+1, count);

        return dp[i][count][min] = (pick + notPick) % MOD;
    }
}
