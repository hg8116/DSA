// https://leetcode.com/problems/maximum-erasure-value/

package MaximumErasureValue1695;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums){
        int maxScore = 0, currScore = 0;
        Set<Integer> set = new HashSet<>();

        for(int l=0, r=0; r<nums.length; r++){
            if(!set.add(nums[r])){
                currScore -= nums[l];
                set.remove(nums[l++]);
            }
            currScore += nums[r];
            maxScore = Math.max(maxScore, currScore);
        }
        return maxScore;
    }
}
