// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

package SubarrayWithGivenSumGFG;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0, sum = 0;
        if (s == 0) {
            ans.add(-1);
            return ans;
        }

        while (i < n) {
            sum += arr[i++];
            while (sum > s)
                sum -= arr[j++];

            if (sum == s) {
                ans.add(j + 1);
                ans.add(i);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }

}
