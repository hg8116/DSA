// https://leetcode.com/problems/search-in-rotated-sorted-array/

package SearchInRotatedSortedArray33;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target){
        int ans = -1;
        int pivot = findPivot(nums);

        ans = binarySearch(0, pivot, nums, target);
        if(ans != -1) return ans;

        ans = binarySearch(pivot + 1, nums.length - 1, nums, target);
        return ans;
    }

    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if((mid < end) && (nums[mid] > nums[mid + 1])) return mid;
            else if((mid > start) && (nums[mid] < nums[mid - 1])) return mid;
            else if(nums[mid] >= nums[start]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch(int start, int end, int[] nums, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
