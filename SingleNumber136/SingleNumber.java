// https://leetcode.com/problems/single-number/

package SingleNumber136;

public class SingleNumber {
    public int singleNumber(int[] arr) {
        int find = arr[0];
        for (int i = 1; i < arr.length; i++)
            find ^= arr[i];
        return find;
    }
}
