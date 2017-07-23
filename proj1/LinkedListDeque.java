
/**
 * Created by shalk on 2017/6/26.
 */
public class LinkedListDeque<T> {

    private Node<T> head;

    private int size;

    LinkedListDeque(){
        head = new Node<T>(null);
        head.pre = head;
        head.next = head;
        size = 0;
    }

    static class Node<T> {
        T item;
        Node<T> pre;
        Node<T> next;


        public Node(T item){
            this.item = item;
            this.pre = null;
            this.next = null;
        }

        public Node(T item, Node<T> pre, Node<T> next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public  String toString() {
            return "Node:" + item.toString();
        }
    }

    /**
     * Add an item to the fron tof the Deque
     *
     * @param item
     */
    public void addFirst(T item) {
        Node<T> node = new Node<T>(item);
        node.next = head.next;
        node.pre =  head.next.pre;
        head.next.pre = node;
        head.next = node;
        size++;
    }


    public void addLast(T item) {
        Node<T> node = new Node<T>(item);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }


    public void printDeque() {
        Node<T> p = head;
        for (int i = 0; i < size; i++) {
            p = p.next;
            System.out.println(p.toString());
        }
        return;
    }

    public T removeFirst() {
        if ( size > 0 ) {
            Node<T> p = head.next;
            head.next.next.pre = head;
            head.next = head.next.next;
            p.next = null;
            p.pre = null;
            size--;
            return p.item;
        }
        return null;
    }

    public T removeLast() {
        if ( size == 0 ) {
            return null;
        }
        Node<T> p = head.pre;
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        p.pre = null;
        p.next = null;
        size--;
        return p.item;
    }

    public T getWithHead(Node<T> head, int index) {
        if (index == 0) {
            return head.next.item;
        }
        return getWithHead(head.next, index-1);
    }

    public T getRecursive(int index) {
        return getWithHead(this.head, index);
    }

    public T get(int index) {
        if ( index >= size ) {
            return null;
        }
        Node<T> p = head.next;
        while (index-- > 0) {
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        System.out.println(deque.size());
    }
}
