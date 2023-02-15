// https://leetcode.com/problems/reverse-pairs/description/

package ReversePairs493;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(nums, left, mid);
            count += mergeSort(nums, mid + 1, right);

            count += merge(nums, left, mid, right);
        }

        return count;
    }

    int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2 * (long) nums[j])
                j++;
            count += j - (mid + 1);
        }

        List<Integer> temp = new ArrayList<>();
        int i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j])
                temp.add(nums[i++]);
            else
                temp.add(nums[j++]);
        }

        while (i <= mid)
            temp.add(nums[i++]);
        while (j <= right)
            temp.add(nums[j++]);

        for (i = left; i <= right; i++)
            nums[i] = temp.get(i - left);

        return count;
    }
}
