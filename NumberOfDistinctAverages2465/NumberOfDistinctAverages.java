// https://leetcode.com/problems/number-of-distinct-averages/

package NumberOfDistinctAverages2465;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Float> set = new HashSet<>();
        int i = 0, j = n - 1;

        while (i < j) {
            set.add(((float) nums[i] + (float) nums[j]) / 2);
            i++;
            j--;
        }

        return set.size();
    }
}
