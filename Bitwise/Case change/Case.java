/*
  Changing letter case using bitwise operator
  32 - space
  65 - A
  97 - a
*/

class Case {
  public static void main(String[] args) {

    char ch = 'a';
    // To upper case
    ch = (char) (ch & '_');
    System.out.println(ch);

    ch = 'A';
    // To lower case
    ch = (char) (ch | ' ');
    System.out.println(ch);

    // Switch the case
    ch = 'A';
    ch = (char) (ch ^ (1 << 5));
    System.out.println(ch);
  }
}