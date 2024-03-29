// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

package ArithmeticSlicesIISubsequence446;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                ans += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }

        return ans;
    }
}
