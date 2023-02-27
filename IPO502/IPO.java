// https://leetcode.com/problems/ipo/description/

package IPO502;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        PriorityQueue<Integer> maxCap = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                maxCap.offer(projects[i][1]);
                i++;
            }
            if (maxCap.isEmpty())
                break;
            w += maxCap.poll();
        }

        return w;
    }
}
