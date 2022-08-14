// https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1

package SegregateEvenAndOddNodesInALinkListGFG;

public class SegregateEvenAndOddNodesInALinkList {
    class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    Node divide(int N, Node head) {
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);

        Node even = evenHead;
        Node odd = oddHead;

        while(head != null){
            Node next = head.next;
            int x = head.data;

            if(x % 2 == 0){
                even.next = head;
                even = even.next;
            }
            else{
                odd.next = head;
                odd = odd.next;
            }
            head.next = null;
            head = next;
        }

        even.next = oddHead.next;
        return evenHead.next;
    }
}