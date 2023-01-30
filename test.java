import javax.swing.*;
import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.*;

class test {
    public static void main(String[] args) {
        int[] edges = {2, 2, 3, -1};

        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int source = 0;
        dist[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(edges[curr] == -1)
                continue;
            dist[edges[curr]] = dist[curr] + 1;
            q.add(edges[curr]);
        }

        System.out.println(Arrays.toString(dist));

    }
}