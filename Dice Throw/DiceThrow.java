/* Return all the ways to form the given target using a dice i.e. using numbers from 1 to 6 */

import java.util.ArrayList;

class DiceThrow {
  public static void main(String[] args) {
    System.out.println(diceRet("", 4));
  }

  // Printing all the combinations
  static void dice(String p, int target) {
    if (target == 0) {
      System.out.println(p);
      return;
    }
    for (int i = 1; i <= 6 && i <= target; i++) {
      dice(p + i, target - i);
    }
  }

  // Returning a list
  static ArrayList<String> diceRet(String p, int target) {
    if (target == 0) {
      ArrayList<String> list = new ArrayList<>();
      if (!p.isEmpty()) {
        list.add(p);
      }
      return list;
    }

    ArrayList<String> list = new ArrayList<>();
    for (int i = 1; i <= 6 && i <= target; i++) {
      list.addAll(diceRet(p + i, target - i));
    }
    return list;
  }
}