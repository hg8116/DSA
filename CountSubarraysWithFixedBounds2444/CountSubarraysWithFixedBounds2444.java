// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/

package CountSubarraysWithFixedBounds2444;

public class CountSubarraysWithFixedBounds2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0, start = -1, min = -1, max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK)
                start = i;
            if (nums[i] == minK)
                min = i;
            if (nums[i] == maxK)
                max = i;

            ans += Math.max(0, Math.min(min, max) - start);
        }

        return ans;
    }
}
