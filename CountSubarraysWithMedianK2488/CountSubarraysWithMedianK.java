// https://leetcode.com/problems/count-subarrays-with-median-k/

package CountSubarraysWithMedianK2488;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMedianK {
    public int countSubarrays(int[] nums, int k) {
        int ind = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k)
                nums[i] = -1;
            else if (nums[i] > k)
                nums[i] = 1;
            else {
                nums[i] = 0;
                ind = i;
            }
        }

        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int left = helper(0, ind, prefixSum);
        int right = helper(ind + 1, nums.length, prefixSum);
        int total = helper(0, nums.length, prefixSum);

        return total - left - right;
    }

    int helper(int l, int r, int[] prefixSum) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = l; i <= r; i++) {
            int currSum = prefixSum[i];
            if (map.containsKey(currSum))
                ans += map.get(currSum);
            if (map.containsKey(currSum - 1))
                ans += map.get(currSum - 1);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return ans;
    }
}
