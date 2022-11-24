// https://leetcode.com/problems/make-the-string-great/

package MakeTheStringGreat1544;

import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32)
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return new String(sb.reverse());

    }
}
