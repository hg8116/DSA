// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

package LongestPalindromeByConcatenatingTwoLetterWords2131;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        int length = 0;

        for (String x : words) {
            int a = x.charAt(0) - 'a';
            int b = x.charAt(1) - 'a';
            if (count[b][a] > 0) {
                count[b][a]--;
                length += 4;
            } else {
                count[a][b] += 1;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i][i] > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}
