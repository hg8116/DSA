// https://leetcode.com/problems/permutations/

// Using recursion and a map

package Permutations46;

import java.util.ArrayList;
import java.util.List;

public class PermutationsApproach1 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        recurPermute(nums, new ArrayList<Integer>(), ans, freq);
        return ans;
    }

    public void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
