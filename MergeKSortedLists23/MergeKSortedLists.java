// https://leetcode.com/problems/merge-k-sorted-lists/description/

package MergeKSortedLists23;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        ListNode temp = new ListNode(-1);
        ListNode prev = temp;

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            prev.next = curr;
            prev = prev.next;
            if (curr.next != null)
                pq.add(curr.next);
        }

        return temp.next;
    }
}
