// https://leetcode.com/problems/subsets-ii/

package SubsetsII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<Integer>(), ans);

        return ans;
    }

    public void findSubsets(int ind, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind; i<nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(ind+1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}
