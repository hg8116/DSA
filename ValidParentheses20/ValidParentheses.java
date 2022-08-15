// https://leetcode.com/problems/valid-parentheses/

package ValidParentheses20;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            if (stack.isEmpty()) return false;
            if (ch == '}' && stack.pop() == '{') return false;
            if (ch == ']' && stack.pop() == '[') return false;
            if (ch == ')' && stack.pop() == '(') return false;
        }

        return stack.isEmpty();
    }
}