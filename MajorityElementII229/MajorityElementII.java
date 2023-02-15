// https://leetcode.com/problems/majority-element-ii/description/

package MajorityElementII229;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int can1 = -1, can2 = -1;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == can1)
                count1++;
            else if (nums[i] == can2)
                count2++;
            else if (count1 == 0) {
                can1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                can2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == can1)
                count1++;
            else if (nums[i] == can2)
                count2++;
        }
        if (count1 > n / 3)
            ans.add(can1);
        if (count2 > n / 3)
            ans.add(can2);
        return ans;
    }
}
