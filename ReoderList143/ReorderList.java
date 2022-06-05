// https://leetcode.com/problems/reorder-list/

package ReoderList143;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode secondHead = reverseList(mid);

        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        while(head != null && secondHead != null){
            newHead.next = head;
            head = head.next;
            newHead = newHead.next;
            newHead.next = secondHead;
            secondHead = secondHead.next;
            newHead = newHead.next;
        }
        newHead.next = null;
        head = temp;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head){
        if(head == null) return null;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
