// https://leetcode.com/problems/palindrome-linked-list/

package PalindromeLinkedList234;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereversehead = headSecond;

        // compare both the halves
        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereversehead);

        return (head == null || headSecond == null);

    }

    private ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

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

        head = prev;
        return head;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
