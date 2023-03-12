// https://leetcode.com/problems/minimum-time-to-complete-trips/description/

package MinimumTimeToCompleteTrips2187;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1, end = 100000000000000L;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long trips = 0;
            for (int i = 0; i < time.length; i++)
                trips += mid / time[i];
            if (trips >= totalTrips)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}
