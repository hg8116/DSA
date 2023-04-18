// https://leetcode.com/problems/merge-strings-alternately/description/

package MergeStringsAlternately1768;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        if (word1.length() == 0)
            return word2;
        if (word2.length() == 0)
            return word1;

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while (i < word1.length())
            sb.append(word1.charAt(i++));
        while (j < word2.length())
            sb.append(word2.charAt(j++));

        return sb.toString();
    }
}
