// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package RemoveNthNodeFromEndOfList19;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;

        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }

        if(head == null || n == 0) return head;
        if(n > len) return null;
        if(n == len) return head.next;

        int i=0;
        node = head;
        while(i < len-n-1){
            node = node.next;
            i++;
        }

        node.next = node.next.next;
        return head;

    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
