// https://leetcode.com/problems/maximum-product-subarray/description/

package MaximumProductSubarray152;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = nums[0], pre = 0, suf = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pre = (pre == 0 ? 1 : pre) * nums[i];
            suf = (suf == 0 ? 1 : suf) * nums[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suf));
        }

        return ans;
    }
}
