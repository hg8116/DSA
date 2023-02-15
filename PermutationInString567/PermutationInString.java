// https://leetcode.com/problems/permutation-in-string/description/

package PermutationInString567;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        if (s1.length() == 0)
            return true;

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];
        int n = s1.length();
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        for (int i = n; i < m; i++) {
            if (Arrays.equals(countS1, countS2))
                return true;
            countS2[s2.charAt(i - n) - 'a']--;
            countS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(countS1, countS2))
            return true;

        return false;
    }
}
