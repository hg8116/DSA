// https://leetcode.com/problems/move-zeroes

package MoveZeroes283;

public class MoveZeroes {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] arr) {
        int i = 0, j = 0, n = arr.length;
        while (i < n) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
    }
}
