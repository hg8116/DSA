// https://leetcode.com/problems/copy-list-with-random-pointer/

package CopyListWithRandomPointer138;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandomPtrs(head);
        return separateList(head);
    }

    public void copyList(Node head){
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
    }

    public void copyRandomPtrs(Node head){
        Node curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
    }

    public Node separateList(Node head){
        Node newHead = new Node(-1);
        Node curr = head;
        Node prev = newHead;
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        return newHead.next;
    }

    private class Node{
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val = val;
        }
    }
}
