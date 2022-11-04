// https://leetcode.com/problems/jump-game-ii/

package JumpGameII45;

public class JumpGameII {
    public int jump(int[] nums) {
        int ans = 0, left = 0, right = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++)
                farthest = Math.max(farthest, i + nums[i]);
            left = right + 1;
            right = farthest;
            ans += 1;
        }

        return ans;
    }
}
