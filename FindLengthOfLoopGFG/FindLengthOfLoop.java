// https://practice.geeksforgeeks.org/problems/find-length-of-loop/1

package FindLengthOfLoopGFG;

public class FindLengthOfLoop {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    static int countNodesinLoop(Node head) {
        if(head == null) return 0;
        if(head.next == null) return 1;

        Node fast = head;
        Node slow = head;
        int len = 0;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    len++;
                }while(temp != slow);
                break;
            }
        }

        return len;
    }

}
