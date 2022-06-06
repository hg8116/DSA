package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuiltExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);

//        System.out.println(queue);
//        System.out.println(queue.remove());
//        System.out.println(queue);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(80);
        deque.add(10);
        deque.addLast(90);
        deque.addFirst(32);
        System.out.println(deque);
        deque.remove();
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
    }
}
