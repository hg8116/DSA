//To find majority element
public class mooresVoting {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6 };
    int count = 0;
    int majorityElement = arr[0];
    for (int x : arr) {
      if (x != majorityElement) {
        count--;
      } else {
        count++;
      }
      if (count == 0) {
        majorityElement = x;
        count = 1;
      }
    }
    System.out.println("Majority Eelement: " + majorityElement);
  }
}