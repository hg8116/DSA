package Algo;

import java.util.Arrays;

public class mergeSort {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 3, 2, 5, 4 };
    mergeSorting(arr, 0, arr.length);

    System.out.println(Arrays.toString(arr));
  }

  // Inplace MergeSort
  static void mergeSorting(int arr[], int l, int r) {
    if(l < r){
      int mid = (l + r) / 2;
      mergeSorting(arr, l, mid);
      mergeSorting(arr, mid+1, r);
      merge(arr, l, mid, r);
    }
  }

  static void merge(int arr[], int l, int m, int r) {
    int[] temp = new int[r-l+1];
    int i = l;
    int j = m + 1;
    int k = 0;

    while(i <= m && j <= r){
      if(arr[i] < arr[j])
        temp[k++] = arr[i++];
      else
        temp[k++] = arr[j++];
    }

    while(i <= m){
      temp[k++] = arr[i++];
    }
    while(j <= r){
      temp[k++] = arr[j++];
    }

    for(i=l, k=0; i<=r; i++){
      arr[i] = temp[k++];
    }
  }

  // // Recursive MergeSort
  // // Time Complexity : O(NlogN)
  // // Space Complexity : O(N)
  // static int[] mergeSorting(int[] arr) {
  // if (arr.length == 1) {
  // return arr;
  // }

  // int mid = arr.length / 2;
  // int left[] = mergeSorting(Arrays.copyOfRange(arr, 0, mid));
  // int right[] = mergeSorting(Arrays.copyOfRange(arr, mid, arr.length));

  // return merge(left, right);
  // }

  // static int[] merge(int first[], int second[]) {
  // int mix[] = new int[first.length + second.length];

  // int i = 0;
  // int j = 0;
  // int k = 0;

  // while (i < first.length && j < second.length) {
  // if (first[i] < second[j]) {
  // mix[k] = first[i];
  // i++;
  // k++;
  // } else {
  // mix[k] = second[j];
  // j++;
  // k++;
  // }
  // }

  // while (i < first.length) {
  // mix[k] = first[i];
  // i++;
  // k++;
  // }

  // while (j < second.length) {
  // mix[k] = second[j];
  // j++;
  // k++;
  // }

  // return mix;
  // }

}
