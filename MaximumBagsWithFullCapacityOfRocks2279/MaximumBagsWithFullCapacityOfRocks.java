// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/

package MaximumBagsWithFullCapacityOfRocks2279;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++)
            diff[i] = capacity[i] - rocks[i];

        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] == 0)
                ans++;
            else {
                if (additionalRocks >= diff[i]) {
                    additionalRocks -= diff[i];
                    ans++;
                } else
                    break;
            }
        }

        return ans;
    }
}
