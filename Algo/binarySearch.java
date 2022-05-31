public class binarySearch {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 4, 5 };
    int target = 2;
    // only works on sorted arrays
    int start = 0;
    int end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        System.out.println("Found: " + mid);
        System.exit(0);
      } else if (arr[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    System.out.println("Not found");
  }
}
