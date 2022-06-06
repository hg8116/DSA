package Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        CustomStack stack = new DynamicStack(4);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
