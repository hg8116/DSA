/* For accessing the ith bit of a number, we can create a bit mask and left shift it n-1 times where n = i */

class Access {
  public static void main(String[] args) {
    // let n = 3
    int a = 5;
    int b = 1;
    b = b << (3 - 1);
    System.out.println(b);
    // we can flip a bit using xor operator
    a = a ^ b;
    System.out.println(a);

    // we can turn a bit off by using not operator

    a = 5;
    b = 1;
    b = b << (3 - 1);
    System.out.println(b);
    a = (~b) & a;
    System.out.println(a);
  }
}
