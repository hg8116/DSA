// https://leetcode.com/problems/rotate-list/

package RotateList61;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }

        ListNode last = head;
        int len = 1;

        while(last.next != null){
            last = last.next;
            len++;
        }

        last.next = head;
        int rotations = k % len;
        int skip = len - rotations;

        ListNode newLast = head;
        for(int i=0; i<skip-1; i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    private class ListNode{
        int val;
        ListNode next;
    }

}
