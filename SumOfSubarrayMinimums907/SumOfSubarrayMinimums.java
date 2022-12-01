// https://leetcode.com/problems/sum-of-subarray-minimums/

package SumOfSubarrayMinimums907;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < arr.length + 1; i++) {
            int curr = i < arr.length ? arr[i] : 0;
            while (stack.peek() != -1 && curr < arr[stack.peek()]) {
                int ind = stack.pop();
                int j = stack.peek();
                int l = ind - j;
                int r = i - ind;
                long add = (long) (l * r * (long) arr[ind]) % 1000000007;
                ans += add;
                ans %= 1000000007;
            }
            stack.push(i);
        }

        return (int) ans;
    }
}
