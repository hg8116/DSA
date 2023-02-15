// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

package FindAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> ans = new ArrayList<>();
        if (s1.length() < s2.length())
            return ans;
        int m = s1.length(), n = s2.length();
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for (int i = 0; i < n; i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        for (int i = n; i < m; i++) {
            if (Arrays.equals(countS1, countS2))
                ans.add(i - n);
            countS1[s1.charAt(i - n) - 'a']--;
            countS1[s1.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countS1, countS2))
            ans.add(m - n);
        return ans;
    }
}
