// https://leetcode.com/problems/reverse-integer/

package ReverseInteger7;

public class ReverseInteger {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE)
            return (int) ans;
        else
            return 0;
    }
}
