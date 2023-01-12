// https://leetcode.com/problems/maximum-ice-cream-bars/

package MaximumIceCreamBars1833;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                ans++;
                coins -= costs[i];
            }
            if (coins <= 0)
                break;
        }
        return ans;
    }
}
