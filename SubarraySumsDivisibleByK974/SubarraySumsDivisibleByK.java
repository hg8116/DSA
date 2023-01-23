// https://leetcode.com/problems/subarray-sums-divisible-by-k/

package SubarraySumsDivisibleByK974;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder < 0)
                remainder += k;
            int count = map.getOrDefault(remainder, 0);
            ans += count;
            map.put(remainder, count + 1);
        }
        return ans;
    }
}
