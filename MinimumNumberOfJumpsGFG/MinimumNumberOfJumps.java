// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1

package MinimumNumberOfJumpsGFG;

public class MinimumNumberOfJumps {
    static int minJumps(int[] arr) {
        int n = arr.length, next = 0, ans = 0, target = 0;
        for (int i = 0; i < n - 1; i++) {
            next = Math.max(next, i + arr[i]);
            if (i == target) {
                ans++;
                target = next;
            }
            if (arr[i] == 0 && i == target)
                return -1;
        }
        return ans;
    }
}
