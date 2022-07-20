import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class test {
  public static void main(String[] args) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    ans.add(new ArrayList<Integer>(list));
//    ans.add(list);
    System.out.println(ans);
    System.out.println(list);
    list.add(5);
    list.add(6);
    ans.add(new ArrayList<Integer>(list));
    System.out.println(ans);
    System.out.println(list);




  }
}