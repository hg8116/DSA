// https://leetcode.com/problems/minimize-deviation-in-array/description/

package MinimizeDeviationInArray1675;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int minVal = Integer.MAX_VALUE;
        for (int x : nums) {
            if (x % 2 == 1)
                x = x * 2;
            minVal = Math.min(x, minVal);
            pq.add(x);
        }

        int ans = Integer.MAX_VALUE;
        while (true) {
            int maxVal = pq.poll();
            ans = Math.min(ans, maxVal - minVal);
            if (maxVal % 2 == 1)
                break;
            maxVal /= 2;
            minVal = Math.min(minVal, maxVal);
            pq.add(maxVal);
        }

        return ans;
    }
}
