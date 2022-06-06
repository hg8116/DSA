// https://leetcode.com/problems/intersection-of-two-linked-lists/

package IntersectionOfTwoLinkedLists160;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;

        while(first != second){
            first = (first == null) ? headB : first.next;
            second = (second == null) ? headA : second.next;
        }

        return first;
    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
