// https://leetcode.com/problems/online-stock-span/

package OnlineStockSpan901;

import java.util.Stack;

class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            span += stack.pop()[1];
        stack.push(new int[]{price, span});

        return span;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
    }
}
