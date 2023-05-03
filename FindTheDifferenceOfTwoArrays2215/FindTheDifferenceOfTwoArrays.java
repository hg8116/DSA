// https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

package FindTheDifferenceOfTwoArrays2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int x : nums1)
            s1.add(x);
        for (int x : nums2)
            s2.add(x);

        for (int x : s1) {
            if (!s2.contains(x))
                list.get(0).add(x);
        }
        for (int x : s2) {
            if (!s1.contains(x))
                list.get(1).add(x);
        }

        return list;
    }
}
