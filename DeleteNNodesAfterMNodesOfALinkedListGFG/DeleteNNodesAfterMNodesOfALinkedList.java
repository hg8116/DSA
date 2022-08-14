// https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1

package DeleteNNodesAfterMNodesOfALinkedListGFG;

public class DeleteNNodesAfterMNodesOfALinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void linkdelete(Node head, int M, int N) {
        Node temp = head;
        while (temp != null) {
            for (int i = 1; i < M && temp != null; i++)
                temp = temp.next;
            Node prev = temp;

            for (int i = 0; i <= N && temp != null; i++)
                temp = temp.next;
            if (prev != null) prev.next = temp;
        }

        return;
    }
}
