// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

package MinimumRoundsToCompleteAllTasks2244;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tasks)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int res = 0;
        for (int val : map.values()) {
            if (val == 1)
                return -1;
            res += (val + 2) / 3;
        }
        return res;
    }
}
