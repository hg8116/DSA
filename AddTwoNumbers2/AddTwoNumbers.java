// https://leetcode.com/problems/add-two-numbers/

package AddTwoNumbers2;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode node = head;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            node.next = new ListNode(sum % 10);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            node = node.next;
        }

        return head.next;
    }

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
}
