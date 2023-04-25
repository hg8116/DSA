// https://leetcode.com/problems/last-stone-weight/description/

package LastStoneWeight1046;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones)
            pq.add(x);

        int curr = 0;
        int ans = -1;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            if (pq.peek() != null) {
                if (curr == pq.peek()) {
                    pq.poll();
                    pq.add(0);
                } else
                    pq.add(curr - pq.poll());
            } else
                return curr;
        }
        return curr;
    }
}
