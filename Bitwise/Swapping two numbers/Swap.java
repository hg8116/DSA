/* Swapping two number without using a thrid variable can be done using bitwise operations. */

class Swap {
  public static void main(String[] args) {
    int x = 10;
    int y = 15;

    System.out.println("Before " + x + " " + y);

    x = x ^ y;
    y = x ^ y;
    x = x ^ y;

    System.out.println("After " + x + " " + y);
  }

  // Another method
  static void swap(int a, int b) {
    // Same as a = a + b
    a = (a & b) + (a | b);

    // Same as a = a - b
    a = a + (~b) + 1;

    // Same as b = a - b
    b = a + (~b) + 1;

  }
}