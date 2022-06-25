// https://leetcode.com/problems/non-decreasing-array/

package NonDecreasingArray665;

public class NonDecreasingArray655 {
    public boolean checkPossibility(int[] nums){
        for(int i=1, change=0, prev=nums[0]; i<nums.length; i++){
            if(nums[i] < prev){
                if(change++ == 1) return false;
                if(i >= 2 && nums[i-2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
}
