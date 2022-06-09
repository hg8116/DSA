// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package TwoSumIIInputArrayIsSorted167;

public class TwoSumIIInputArrayIsSorted {
    class Solution {
        public int[] twoSum(int[] arr, int target) {
            int ans[] = new int[]{-1, -1};

            int start = 0;
            int end = arr.length-1;

            while(start < end){
                if(arr[start] + arr[end] == target){
                    return new int[]{start+1, end+1};
                }
                else if(arr[start] + arr[end] > target){
                    end--;
                }
                else{
                    start++;
                }
            }
            return ans;
        }
    }
}
