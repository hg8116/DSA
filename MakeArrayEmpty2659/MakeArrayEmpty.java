// https://leetcode.com/problems/make-array-empty/description/

package MakeArrayEmpty2659;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        long n = nums.length;
        long ans = n;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(nums[i], i);

        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (map.get(nums[i]) < map.get(nums[i - 1]))
                ans += n - i;
        }

        return ans;
    }
}
