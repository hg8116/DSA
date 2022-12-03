// https://leetcode.com/problems/find-the-pivot-integer/

package FindThePivotInteger2485;

public class FindThePivotInteger {
    public int pivotInteger(int n) {
        int sum = (n * (n + 1)) / 2;
        int left = 0;
        for (int i = 0; i <= n; left += i++)
            if (left * 2 == sum - i) return i;

        return -1;
    }
}
