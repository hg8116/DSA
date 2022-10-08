package Algo;

import java.util.Arrays;

public class insertionSort {
    static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int item = arr[i];
            int j = i;
            while (j > 0 && item < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = item;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
