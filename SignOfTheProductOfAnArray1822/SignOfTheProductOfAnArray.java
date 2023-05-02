// https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

package SignOfTheProductOfAnArray1822;

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int sign = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0)
                sign *= -1;
            else if(nums[i] == 0){
                sign *= 0;
                return 0;
            }
        }

        return sign > 0 ? 1 : -1;
    }
}
