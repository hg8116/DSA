// https://leetcode.com/problems/dota2-senate/description/

package Dota2Senate649;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R')
                r.add(i);
            else
                d.add(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() < d.peek()) {
                r.add(n++);
            } else
                d.add(n++);
            r.poll();
            d.poll();
        }

        if (r.isEmpty())
            return "Dire";
        return "Radiant";
    }
}
