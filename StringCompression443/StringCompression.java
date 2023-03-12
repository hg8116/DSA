// https://leetcode.com/problems/string-compression/description/

package StringCompression443;

public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, ans = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i])
                groupLength++;
            chars[ans++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray())
                    chars[ans++] = c;
            }
            i += groupLength;
        }

        return ans;
    }
}
