// https://leetcode.com/problems/permutations/submissions/

// Using recursion and swapping

package Permutations46;

import java.util.ArrayList;
import java.util.List;

public class PermutationsApproach2 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    public void recurPermute(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<nums.length; i++){
            swap(i, ind, nums);
            recurPermute(ind + 1, nums, ans);
            swap(i, ind, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
