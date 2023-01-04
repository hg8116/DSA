// https://leetcode.com/problems/remove-stones-to-minimize-the-total/

package RemoveStonesToMinimizeTheTotal1962;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : piles)
            pq.add(x);

        while (k > 0) {
            int curr = pq.poll();
            curr = (int) Math.ceil((double) curr / 2);
            pq.add(curr);
            k--;
        }

        int ans = 0;
        for (int x : pq)
            ans += x;

        return ans;
    }
}
