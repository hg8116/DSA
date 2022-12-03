// https://leetcode.com/problems/determine-if-two-strings-are-close/

package DetermineIfTwoStringsAreClose1657;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n != m)
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (map1.equals(map2))
            return true;

        if (!map1.keySet().equals(map2.keySet()))
            return false;

        List<Integer> l1 = new ArrayList<>(map1.values());
        List<Integer> l2 = new ArrayList<>(map2.values());
        System.out.println(l1);
        System.out.println(l2);

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);
    }
}
