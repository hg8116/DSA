public class linearSearch {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 4, 5 };
    int target = 5;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        System.out.println("Found: " + i);
        System.exit(0);
      }
    }
    System.out.println("Not found");
  }
}