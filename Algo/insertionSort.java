public class insertionSort {
  public static void main(String[] args) {
    int arr[] = new int[] { 2, 5, 1, 4, 3 };
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        } else {
          break;
        }
      }
    }
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }
}
