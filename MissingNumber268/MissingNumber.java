// https://leetcode.com/problems/missing-number/

package MissingNumber268;

public class MissingNumber {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int ideal = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        return ideal - sum;
    }
}
