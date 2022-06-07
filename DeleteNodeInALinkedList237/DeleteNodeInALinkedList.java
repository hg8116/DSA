// https://leetcode.com/problems/delete-node-in-a-linked-list/

package DeleteNodeInALinkedList237;

public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private class ListNode{
        int val;
        ListNode next;
    }
}
