// https://leetcode.com/problems/add-to-array-form-of-integer/description/

package AddToArrayFormOfInteger989;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0, toAdd = 0, i = num.length - 1;

        while (i >= 0 || k > 0 || carry > 0) {
            toAdd = k % 10 + carry + (i >= 0 ? num[i--] : 0);
            carry = toAdd / 10;
            toAdd = toAdd % 10;
            k = k / 10;
            ans.add(0, toAdd);
        }

        return ans;
    }
}
