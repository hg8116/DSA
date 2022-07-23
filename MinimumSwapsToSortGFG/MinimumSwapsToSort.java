// https://practice.geeksforgeeks.org/problems/minimum-swaps/1

package MinimumSwapsToSortGFG;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort {
    public int minSwaps(int nums[]){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) != i){
                ans++;
                swap(i, map.get(nums[i]), nums);
                i--;
            }
        }

        return ans;
    }

    public void swap(int x, int y, int[] nums){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
