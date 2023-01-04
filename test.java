import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] values = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        for (int i = 0; i < values.length; i++) {
            int x = map.getOrDefault(values[i], 0);
            map.put(values[i], x + 1);
        }

//        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int curr = 0;
            if (count % 3 == 1 && count % 2 == 1)
                break;
            while (count % 3 == 0) {
                curr++;
            }
            while (count % 2 == 0) {
                curr++;
            }
        }

        System.out.println(map);
    }
}