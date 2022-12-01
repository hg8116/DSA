// https://leetcode.com/problems/insert-delete-getrandom-o1/

package InsertDeleteGetRandomO1380;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;

            int i = map.remove(val);
            int last = list.size() - 1;
            if (i != last) {
                int lastVal = list.get(last);
                list.set(i, lastVal);
                map.put(lastVal, i);
            }
            list.remove(last);
            map.remove(val);
            return true;
        }


        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
