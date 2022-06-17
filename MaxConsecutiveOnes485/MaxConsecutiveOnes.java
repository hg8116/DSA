// https://leetcode.com/problems/max-consecutive-ones/

package MaxConsecutiveOnes485;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){

            if(nums[i] == 1) count++;
            if(nums[i] != 1) count=0;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}