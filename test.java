import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

public class test {
    class Node {
        Node left, right;
        int val;
    }

    public static void main(String[] args) {
        Node root = null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }

    }
}


