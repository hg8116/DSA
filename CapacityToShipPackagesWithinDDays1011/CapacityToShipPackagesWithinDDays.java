// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

package CapacityToShipPackagesWithinDDays1011;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;
        int start = arr[0];
        int end = 0;
        for (int x : arr) {
            start = x > start ? x : start;
            end += x;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0, curr = 0;
            for (int i = 0; i < n; i++) {
                curr = curr + arr[i];
                if (curr > mid) {
                    count++;
                    curr = arr[i];
                }
            }

            if (count >= days)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
