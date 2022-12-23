// https://leetcode.com/problems/daily-temperatures/

package DailyTemperatures739;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
