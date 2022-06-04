package LinkedList;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;

    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    public void insert(int val, int index){
        if(index > size || index < 0){
            System.out.println("Index out of bounds");
            return;
        }
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i=1; i<index; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Node not found");
        return null;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        Node temp = head;
        if(size == 1){
            head = null;
            tail = null;
            return -1;
        }
        while(temp.next.next != null){
            temp = temp.next;
        }
        int val = temp.next.value;
        tail = temp;
        temp.next = null;
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Remove Duplicates from sorted linked list
    public void duplicates(){
        Node node = head;

        while(node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }
            else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // Merge two sorted linked list
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }
            else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    // Cycle detection in linked list
    // Using fast and slow pointer method

    public boolean hasCycle(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Length of cycle
    public int cycleLen(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                // calc length
                int length = 0;
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    // Find starting node of the cycle
    public Node cycleStart(){
        int length = 0;
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                break;
            }
        }

        if(length == 0) return null;

        Node first = head;
        Node second = head;

        while(length > 0){
            second = second.next;
            length--;
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }

        return first;
    }

    // Find middle node of the linked list
    public Node middleNode() {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    // Bubble sort linked list
    public void bubbleSort(){
        bubbleSort(size-1, 0);
    }

    public void bubbleSort(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            Node first = get(col);
            Node second = get(col + 1);

            if(first.value > second.value){
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }
                else if(second == tail){
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }
                else{
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        }
        else{
            bubbleSort(row-1, col);
        }
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
