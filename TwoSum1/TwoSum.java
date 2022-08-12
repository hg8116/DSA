// https://leetcode.com/problems/two-sum/

package TwoSum1;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++){
            int difference = target - nums[i];
            if(map.containsKey(difference)){
                ans[0] = i;
                ans[1] = map.get(difference);
            }
            else{
                map.put(nums[i], i);
            }
        }

        return ans;
    }

}
