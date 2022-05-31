public class kadanes {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 4, 5 };
    int maxSum = 0;
    int curSum = 0;

    for (int i = 0; i < arr.length; i++) {
      curSum += arr[i];
      if (arr[i] > curSum) {
        curSum = arr[i];
      }
      maxSum = curSum > maxSum ? curSum : maxSum;
    }
    System.out.println("Sum: " + maxSum);
  }
}
