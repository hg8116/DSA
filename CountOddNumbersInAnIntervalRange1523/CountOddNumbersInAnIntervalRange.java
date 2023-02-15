// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

package CountOddNumbersInAnIntervalRange1523;

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        return (((low % 2 == 1) || (high % 2 == 1)) ? 1 : 0) + ((high - low) / 2);
    }
}
