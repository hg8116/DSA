// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package RemoveAllAdjacentDuplicatesInString1047;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i))
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
