import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(13);
        list.add(12);
        list.add(14);
        list.add(17);

        System.out.println(list);
        System.out.println(list.remove(4));
        System.out.println(list);
    }
}