
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        int count = sc.nextInt();
        int[] score = new int[n];
        for (int i=0; i<n; i++)
            score[i] = sc.nextInt();

        stack.push(score[0]);
        int i=1;
        while(i < n){
            while(!stack.isEmpty() && stack.peek() < score[i] && count > 0){
                stack.pop();
                count--;
            }
            stack.push(score[i]);
            i++;
        }

        System.out.println(stack);
    }
}


