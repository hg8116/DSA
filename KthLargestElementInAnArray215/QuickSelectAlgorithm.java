// https://leetcode.com/problems/kth-largest-element-in-an-array/

package KthLargestElementInAnArray215;

public class QuickSelectAlgorithm {
    public int findKthLargest(int[] nums, int k){
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int low, int high, int k){
        int pivot = low;

        for(int i=low; i<high; i++){
            if(nums[i] <= nums[high]){
                swap(nums, i, pivot++);
            }
        }
        swap(nums, pivot, high);

        int count = high - pivot + 1;
        if (count == k) return nums[pivot];
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
