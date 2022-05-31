public class selectionSort {
  static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  static int getMaxIndex(int arr[], int start, int end) {
    int max = start;
    for (int i = start; i <= end; i++) {
      if (arr[max] < arr[i]) {
        max = i;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int arr[] = new int[] { 3, 1, 4, 5, 6 };
    for (int i = 0; i < arr.length; i++) {
      int last = arr.length - i - 1;
      int maxIndex = getMaxIndex(arr, 0, last);
      swap(arr, maxIndex, last);
    }
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }
}
