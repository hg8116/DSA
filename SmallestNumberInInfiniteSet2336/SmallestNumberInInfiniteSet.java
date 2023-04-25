// https://leetcode.com/problems/smallest-number-in-infinite-set/description/

package SmallestNumberInInfiniteSet2336;

import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {
        PriorityQueue<Integer> pq;
        int count;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            count = 1;
        }

        public int popSmallest() {
            if (!pq.isEmpty())
                return pq.poll();
            return count++;
        }

        public void addBack(int num) {
            if (count > num && !pq.contains(num))
                pq.add(num);
        }
    }
}
