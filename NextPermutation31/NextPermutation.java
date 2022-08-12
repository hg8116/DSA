// https://leetcode.com/problems/next-permutation/

package NextPermutation31;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (nums == null || n <= 1) return;

        // Finding the index before pivot element
        int pivot = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot != -1) {
            // Finding the min greater than pivot
            int toSwap = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[pivot]) {
                    toSwap = i;
                    break;
                }
            }
            swap(nums, pivot, toSwap);
        }

        // Reversing after pivot till end
        reverse(nums, pivot + 1, n - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int s, int e) {
        while (s < e)
            swap(arr, s++, e--);
    }
}