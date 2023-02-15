import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4};
        List<Integer> temp = new ArrayList<>();
        temp = Arrays.asList(arr);
        System.out.println(temp);
    }
}


