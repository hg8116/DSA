import java.util.*;

class test {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(6);
    list.add(6);
    list.add(5);
    list.add(6);

    Collections.sort(list);

    System.out.println(list);
    int ans = Collections.binarySearch(list, 6);
    System.out.println(ans);
  }
}