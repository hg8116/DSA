// https://leetcode.com/problems/longest-subsequence-with-limited-sum/

package LongestSubsequenceWithLimitedSum2389;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {
    // Brute force
    /*
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            int count = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] <= queries[j]) {
                    sum += nums[i];
                    count++;
                }
            }
            ans[j] = count;
        }

        return ans;
    }
    */

    // Using prefix sum and binary search
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] ans = new int[m];
        Arrays.sort(nums);
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        for (int i = 0; i < m; i++) {
            ans[i] = Math.abs(Arrays.binarySearch(nums, queries[i]) + 1);
        }
        return ans;
    }
}
