/* Application Class */

package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(17);
        list.insertFirst(18);
        list.insertFirst(4);
        list.insertLast(99);
        list.insert(100, 3);
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        System.out.println(list.delete(2));

        list.display();
    }
}
