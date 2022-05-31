public class bubbleSort {
  public static void main(String[] args) {
    int arr[] = new int[] { 2, 5, 1, 4, 3 };
    boolean swapped = false;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }
}
