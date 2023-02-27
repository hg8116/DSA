// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

package FindTheSmallestDivisorGivenAThreshold1283;

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1, end = nums[0];
        for (int x : nums)
            end = Math.max(x, end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int div = 0;
            for (int x : nums)
                div += (x + mid - 1) / mid;
            if (div > threshold)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
}
