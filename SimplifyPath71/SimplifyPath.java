// https://leetcode.com/problems/simplify-path/description/

package SimplifyPath71;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < p.length; i++) {
            if (p[i].equals(".") || p[i].equals(""))
                continue;
            else if (p[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
                continue;
            }
            stack.push(p[i]);
        }

        if (stack.isEmpty())
            ans.append("/");
        for (String x : stack) {
            ans.append("/");
            ans.append(x);
        }

        return ans.toString();
    }
}
