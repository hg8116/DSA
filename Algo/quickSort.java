package Algo;

import java.util.Arrays;

public class quickSort {
    /*
     * Recurrence relation
     * T(n) = T(k) + T(n - k - 1) + O(n)
     * Time Complexity : O(NlogN)
     * Not Stable
     * Merge Sort is better in linked list due to non-contagious memory
     * allocation.
     */

    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 1, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static int partition(int arr[], int low, int high) {
        int i = low;
        int j = high;
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        while (true) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j)
                swap(arr, i, j);
            else
                return j;
        }
    }

    static void quickSort(int arr[], int low, int high) {
        if (low >= high) return;
        int part = partition(arr, low, high);
        quickSort(arr, low, part);
        quickSort(arr, part + 1, high);
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
