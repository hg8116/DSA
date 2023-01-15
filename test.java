import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        String s = new String("hello");
        String b = new String("hello");
        System.out.println(s == b);
        String a = "hello";
        String d = "s";
        System.out.println(a == d);
    }
}