// https://leetcode.com/problems/insert-interval/

package InsertInterval57;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int[] x : intervals) {
            if (newInterval[1] < x[0]) {
                ans.add(newInterval);
                newInterval = x;
            } else if (x[1] < newInterval[0])
                ans.add(x);
            else {
                newInterval[0] = Math.min(newInterval[0], x[0]);
                newInterval[1] = Math.max(newInterval[1], x[1]);
            }
        }
        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);
    }
}
