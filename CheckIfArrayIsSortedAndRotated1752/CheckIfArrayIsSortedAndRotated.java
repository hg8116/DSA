// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

package CheckIfArrayIsSortedAndRotated1752;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int decCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                decCount++;
        }
        return decCount <= 1 ? true : false;
    }
}
