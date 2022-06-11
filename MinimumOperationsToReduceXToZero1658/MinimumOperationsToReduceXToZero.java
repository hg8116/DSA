// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

package MinimumOperationsToReduceXToZero1658;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x){
        int target = -x;
        for(int i: nums) target += i;

        if(target == 0) return nums.length;
        if(target < 0) return -1;

        int res = -1, sum = 0, left = 0;

        for(int right=0; right<nums.length; right++){
            sum += nums[right];
            if(sum > target){
                sum -= nums[left++];
            }
            if(sum == target){
                res = Math.max(res, right-left+1);
            }
        }

        return res == -1 ? -1 : nums.length-res;
    }
}
