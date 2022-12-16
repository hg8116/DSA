// https://leetcode.com/problems/implement-queue-using-stacks/

package ImplementQueueUsingStacks232;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.add(x);
        }

        public int pop() {
            while (!s1.isEmpty()) {
                int x = s1.pop();
                s2.add(x);
            }
            int ans = s2.pop();
            while (!s2.isEmpty()) {
                int x = s2.pop();
                s1.add(x);
            }

            return ans;
        }

        public int peek() {
            return s1.firstElement();
        }

        public boolean empty() {
            if (s1.isEmpty())
                return true;
            return false;
        }
    }
}
