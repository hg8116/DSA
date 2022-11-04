// https://leetcode.com/problems/group-anagrams/

package GroupAnagrams49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String x : strs) {
            char[] ch = x.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            if (!map.containsKey(temp))
                map.put(temp, new ArrayList<>());
            map.get(temp).add(x);
        }
        return new ArrayList<>(map.values());
    }
}
