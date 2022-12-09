// https://leetcode.com/problems/minimum-average-difference/

package MinimumAverageDifference2256;

public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = 0;
        long min = Integer.MAX_VALUE;
        long sum = 0, leftSum = 0, rightSum = 0;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long diff = Math.abs(leftSum / (i + 1) - (n - i == 1 ? 0 : rightSum / (n - i - 1)));
            if (diff < min) {
                min = diff;
                ans = i;
            }
        }
        return ans;
    }
}
