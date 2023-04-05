// https://leetcode.com/problems/minimize-maximum-of-array/description/

public class MinimizeMaximumOfArray2439 {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            ans = Math.max((currSum + i) / (i + 1), ans);
        }

        return (int) ans;
    }
}
