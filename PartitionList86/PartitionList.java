// https://leetcode.com/problems/partition-list/

package PartitionList86;

public class PartitionList {
    private class ListNode {
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

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(head != null){
            if(head.val < x){
                temp1.next = head;
                temp1 = temp1.next;
            }

            else if(head.val >= x){
                temp2.next = head;
                temp2 = temp2.next;
            }

            head = head.next;
        }

        head1 = head1.next;
        head2 = head2.next;

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        temp1.next = null;
        temp2.next = null;

        temp1.next = head2;

        return head1;
    }
}
