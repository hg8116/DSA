// https://leetcode.com/problems/reverse-nodes-in-k-group/

package ReverseNodesInKGroup25;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode prev = newHead;
        ListNode present = newHead;
        ListNode next = newHead;

        newHead.next = head;

        int len = 0;

        while(present.next != null){
            present = present.next;
            len++;
        }

        while(len >= k){
            present = prev.next;
            next = present.next;

            for(int i=1; i<k; i++){
                present.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = present.next;
            }

            len -= k;
            prev = present;
        }

        return newHead.next;

    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
