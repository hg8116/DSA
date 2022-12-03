// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

package AppendCharactersToStringToMakeSubsequence2486;

public class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int first = s.length();
        int second = t.length();

        int i = 0, j = 0;
        while (i < first && j < second) {
            if (s.charAt(i) == t.charAt(j)) j++;
            i++;
        }

        return second - j;
    }
}
