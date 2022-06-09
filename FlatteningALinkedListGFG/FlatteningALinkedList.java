// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

package FlatteningALinkedListGFG;

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/

public class FlatteningALinkedList {
    Node flatten(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);
        return root;
    }

    Node merge(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;

        while(a != null && b != null){
            if(a.data < b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        temp.bottom = (a != null) ? a : b;
        return res.bottom;
    }

    private class Node{
        int data;
        Node next;
        Node bottom;

        Node(int data){
            this.data = data;
        }
    }
}
