import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
        map2.put(3, 3);
        map2.put(2, 2);
        map2.put(1, 1);
        System.out.println(map1.values().equals(map2.values()));
        System.out.println(map1.values());
        System.out.println(map2.values());
        System.out.println(map2);

        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(list1.equals(list2));
        System.out.println(2 ^ 3);
    }
}