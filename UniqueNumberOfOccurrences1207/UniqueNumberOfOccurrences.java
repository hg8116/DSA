// https://leetcode.com/problems/unique-number-of-occurrences/

package UniqueNumberOfOccurrences1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}
