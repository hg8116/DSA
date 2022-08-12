// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

package SortAnArrayOf0s1sand2sGFG;

public class SortAnArrayOf0s1sand2s {
    public static void sort012(int a[], int n) {
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }
        int i = 0;
        while (count[0] > 0) {
            a[i++] = 0;
            count[0]--;
        }
        while (count[1] > 0) {
            a[i++] = 1;
            count[1]--;
        }
        while (count[2] > 0) {
            a[i++] = 2;
            count[2]--;
        }
    }
}
