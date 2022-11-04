// https://leetcode.com/problems/odd-string-difference/

package OddStringDifference2451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OddStringDifference {
    public String oddString(String[] words) {
        if (words.length == 0) return "";
        Map<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
        int n = words.length;
        int wordSize = words[0].length();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < wordSize - 1; j++) {
                int diff = words[i].charAt(j) - words[i].charAt(j + 1);
                temp.add(diff);
            }
            if (!map.containsKey(temp)) map.put(temp, new ArrayList<>());
            map.get(temp).add(words[i]);
        }

        for (ArrayList<String> x : map.values()) {
            if (x.size() == 1)
                return x.get(0);
        }

        return "";
    }
}
