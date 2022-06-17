// https://leetcode.com/problems/combination-sum-ii/

package CombinationSumII40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<Integer>());
        return ans;
    }

    public void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<arr.length; i++){
            if(i > ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }


}
