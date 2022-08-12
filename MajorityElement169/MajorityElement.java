// https://leetcode.com/problems/majority-element/

package MajorityElement169;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Moore's Voting Algo
        int val = nums[0];
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == val)
                count++;
            else
                count--;

            if(count == 0){
                val = nums[i];
                count++;
            }
        }

        return val;
    }

}
