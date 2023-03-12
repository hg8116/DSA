// https://leetcode.com/problems/linked-list-random-node/description/

package LinkedListRandomNode382;

import java.util.ArrayList;

public class LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        ArrayList<Integer> list = new ArrayList<>();

        public Solution(ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return list.get((int) (list.size() * Math.random()));
        }
    }
}
