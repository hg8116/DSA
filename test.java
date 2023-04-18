
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] scores = new int[n];
        for (int i=0; i<n; i++)
            scores[i] = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        stack.push(scores[0]);
        int i=1;
        while(i < n){
            while(!stack.isEmpty() && stack.peek() < scores[i] && m > 0){
                stack.pop();
                m--;
            }
            stack.push(scores[i]);
            i++;
        }

        for(int x: stack)
            System.out.print(x + " ");
    }
}


