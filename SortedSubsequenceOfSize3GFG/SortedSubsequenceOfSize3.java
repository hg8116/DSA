// https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1

package SortedSubsequenceOfSize3GFG;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SortedSubsequenceOfSize3 {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        int[] smaller = new int[n];
        int[] greater = new int[n];

        smaller[0] = -1;
        greater[n - 1] = -1;
        int min = 0, max = n - 1;

        for (int i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)) {
                min = i;
                smaller[i] = -1;
            } else
                smaller[i] = min;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(max)) {
                max = i;
                greater[i] = -1;
            } else
                greater[i] = max;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                ans.add(arr.get(smaller[i]));
                ans.add(arr.get(i));
                ans.add(arr.get(greater[i]));
                break;
            }
        }

        return ans;
    }
}