/* This algo is used to count the set bits of a binary number */
public class BrainKernighan {
  static int count(int n) {
    int c = 0;
    while (n != 0) {
      c++;
      n = n & (n - 1);
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(count(10));
  }
}
