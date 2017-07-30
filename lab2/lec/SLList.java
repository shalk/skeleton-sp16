public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** sentinel.next point to first node */
    private IntNode sentinel;

    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next  = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x) {
        IntNode last = getLastNode();
        last.next = new IntNode(x, null);;
        size = size + 1;
    }

    private IntNode getLastNode() {
        IntNode p = sentinel;
        while (p.next !=  null) {
            p = p.next;
        }
        return p;
    }

    public int getLast() {
        IntNode p = getLastNode();
        return p.item;
    }

//    private static int size(IntNode node) {
//        if (node == null) {
//           return 0;
//        }
//        return 1 + size(node.next);
//    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList list = new SLList();
        list.addLast(30);
        System.out.println(list.getFirst());
        System.out.println(list.size());
    }
}