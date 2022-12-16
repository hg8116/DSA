import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.add(5);
        s1.add(6);
        s1.add(7);
        System.out.println(s1.firstElement());
        System.out.println(s1);

        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
//        System.out.println(q.peek());
    }
}