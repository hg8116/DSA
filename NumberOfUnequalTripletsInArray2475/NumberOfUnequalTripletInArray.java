// https://leetcode.com/problems/number-of-unequal-triplets-in-array/

package NumberOfUnequalTripletsInArray2475;

public class NumberOfUnequalTripletInArray {
    public int unequalTriplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i])
                        count++;
                }
            }
        }
        return count;
    }
}
