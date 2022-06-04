package Algo;

import java.util.Arrays;

public class quickSort {
  /*
   * Recurrence relation
   * T(n) = T(k) + T(n - k - 1) + O(n)
   * Time Complexity : O(NlogN)
   * Not Stable
   * Merge Sort is better in linked list due to non contagious memory
   * allocation.
   */

  public static void main(String[] args) {
    int arr[] = new int[] { 3, 2, 1, 4, 5 };
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  static void sort(int arr[], int low, int high) {
    if (low >= high) {
      return;
    }

    int s = low;
    int e = high;
    int m = s + (e - s) / 2;
    int pivot = arr[m];

    while (s <= e) {
      while (arr[s] < pivot) {
        s++;
      }
      while (arr[e] > pivot) {
        e--;
      }
      if (s <= e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        s++;
        e--;
      }
    }
    sort(arr, low, e);
    sort(arr, s, high);
  }
}
