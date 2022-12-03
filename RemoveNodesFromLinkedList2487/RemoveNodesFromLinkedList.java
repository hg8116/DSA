// https://leetcode.com/problems/remove-nodes-from-linked-list/

package RemoveNodesFromLinkedList2487;

import java.util.ArrayList;
import java.util.List;

public class RemoveNodesFromLinkedList {
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

    public ListNode removeNodes(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (arr.size() == 0)
                arr.add(temp.val);
            else {
                while (arr.size() > 0 && temp.val > arr.get(arr.size() - 1))
                    arr.remove(arr.size() - 1);
                arr.add(temp.val);
            }
            temp = temp.next;
        }
        ListNode ans = new ListNode(arr.get(0));
        temp = ans;
        for (int i = 1; i < arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }

        return ans;
    }
}
