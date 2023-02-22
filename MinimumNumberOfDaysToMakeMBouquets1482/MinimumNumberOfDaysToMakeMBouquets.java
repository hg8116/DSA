// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

package MinimumNumberOfDaysToMakeMBouquets1482;

public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int start = 1, end = Integer.MAX_VALUE;
        if ((long) m * k > n)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2, flo = 0, bou = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] > mid)
                    flo = 0;
                else if (++flo >= k) {
                    bou++;
                    flo = 0;
                }
            }
            if (bou < m)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
