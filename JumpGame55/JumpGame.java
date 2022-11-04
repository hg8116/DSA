// https://leetcode.com/problems/jump-game/

package JumpGame55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int goalInd = nums.length-1;
        for(int i=goalInd; i>=0; i--){
            if(nums[i] >= goalInd-i)
                goalInd = i;
        }
        return goalInd == 0;
    }
}
