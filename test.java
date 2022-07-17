import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class test {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();

    map.put("a", 1);
    map.put("b", 2);
    map.put("a", 3);

    System.out.println(map);

  }
}