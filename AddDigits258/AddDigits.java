// https://leetcode.com/problems/add-digits/description/

package AddDigits258;

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        return (num % 9) == 0 ? 9 : num % 9;
    }
}
