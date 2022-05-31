class Power {

  static boolean check(int n) {
    return Math.ceil((Math.log(n)) / Math.log(2)) == Math.floor((Math.log(n)) / Math.log(2));
  }

  // Using bitwise operator
  static boolean checkBit(int n) {
    return ((n != 0) && ((n & (n - 1)) == 0));
  }

  public static void main(String[] args) {
    System.out.println(checkBit(16));
  }
}