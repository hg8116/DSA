// https://leetcode.com/problems/linked-list-cycle-ii/

package LinkedListCycleII142;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    len++;
                } while (temp != slow);
                break;
            }
        }
        if (len == 0) return null;
        ListNode first = head;
        ListNode second = head;
        while (len > 0) {
            second = second.next;
            len--;
        }

        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }
}