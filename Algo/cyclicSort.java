public class cyclicSort {
  public static void main(String[] args) {
    int arr[] = new int[] { 4, 2, 1, 3, 5 };
    int i = 0;
    while (i < arr.length) {
      int correct = arr[i] - 1;
      if (arr[correct] != arr[i]) {
        int temp = arr[correct];
        arr[correct] = arr[i];
        arr[i] = temp;
      } else {
        i++;
      }
    }
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }
}
