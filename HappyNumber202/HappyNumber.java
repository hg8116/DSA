// https://leetcode.com/problems/happy-number/
package HappyNumber202;

import org.w3c.dom.ls.LSOutput;

// Using fast and slow pointer method

public class HappyNumber {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }

    private static int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(5));
    }
}
