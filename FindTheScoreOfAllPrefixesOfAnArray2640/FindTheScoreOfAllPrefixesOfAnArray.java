// https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/description/

package FindTheScoreOfAllPrefixesOfAnArray2640;

public class FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        int[] maxEl = new int[n];
        int currMax = nums[0];
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
            maxEl[i] = currMax;
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i] + maxEl[i];
        }
        long currSum = ans[0];
        for (int i = 1; i < n; i++) {
            currSum += ans[i];
            ans[i] = currSum;
        }

        return ans;
    }
}
