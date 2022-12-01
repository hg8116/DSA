// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

package FindPlayersWithZeroOrOneLosses2225;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] x : matches) {
            map.put(x[0], map.getOrDefault(x[0], 0));
            map.put(x[1], map.getOrDefault(x[1], 0) + 1);
        }
        for (Integer x : map.keySet()) {
            if (map.get(x) <= 1)
                ans.get(map.get(x)).add(x);
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));

        return ans;
    }
}
