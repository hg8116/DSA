// https://leetcode.com/problems/reverse-linked-list-ii/

package ReverseLinkedListII92;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        // skip the first left-1 nodes
        ListNode present = head;
        ListNode prev = null;

        for(int i=0;  i<left-1 && present != null; i++){
            prev = present;
            present = present.next;
        }

        ListNode last = prev;
        ListNode newEnd = present;

        // reverse btw left and right;
        ListNode next = present.next;
        for(int i=0; i<right-left+1 && present != null; i++){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }
        else{
            head = prev;
        }

        newEnd.next = present;
        return head;
    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
