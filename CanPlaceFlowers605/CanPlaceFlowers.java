// https://leetcode.com/problems/can-place-flowers/description/

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == len - 1) ? 0 : flowerbed[i + 1];
                int next = (i == 0) ? 0 : flowerbed[i - 1];
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }
}