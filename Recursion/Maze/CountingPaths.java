/* 
Suppose you are having a 3x3 matrix and a person is standing on (1, 1). The person needs to go to (3, 3) 
but can only move in DOWN or RIGHT direction. Count the number of paths & Print all the paths.
*/

package Recursion.Maze;

import java.util.ArrayList;

class CountingPaths {
  public static void main(String[] args) {
    System.out.print(count(3, 3));
    path("", 3, 3);
    System.out.println(pathRet("", 3, 3));
    System.out.println(pathRetDiagonal("", 3, 3));

  }

  static int count(int r, int c) {
    if (r == 1 || c == 1) {
      return 1;
    }

    int left = count(r - 1, c);
    int right = count(r, c - 1);

    return left + right;
  }

  static void path(String p, int r, int c){
    if(r == 1 && c == 1){
      System.out.println(p);
      return;
    }

    if(r > 1){
      path(p + 'D', r-1, c);
    }
    if(c > 1){
      path(p + 'R', r, c-1);
    }
  }

  static ArrayList<String> pathRet(String p, int r, int c){
    if(r == 1 && c == 1){
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }

    ArrayList<String> list = new ArrayList<>();

    if(r > 1){
      list.addAll(pathRet(p + 'D', r-1, c));
    }
    if(c > 1){
      list.addAll(pathRet(p + 'R', r, c - 1));
    }

    return list;
  }

  /* If we can also move diagonally */
  static ArrayList<String> pathRetDiagonal(String p, int r, int c){
    if(r == 1 && c == 1){
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }

    ArrayList<String> list = new ArrayList<>();
    if(r > 1 && c > 1){
      list.addAll(pathRetDiagonal(p + 'D', r-1, c-1));
    }
    if(r > 1){
      list.addAll(pathRetDiagonal(p + 'V', r-1, c));
    }
    if(c > 1){
      list.addAll(pathRetDiagonal(p + 'H', r, c - 1));
    }

    return list;
  }

}