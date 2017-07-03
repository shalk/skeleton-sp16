/**
 * Created by shalk on 2017/6/26.
 */

public class ArrayDeque<Item> {

    private Item[] items;
    private int size;

    /* index of head
    *
    */
    private int head;

    public ArrayDeque() {
        items = (Item[])new Object[16];
        size = 0;
        head = 0;
    }

    public double usage() {
        return size * 1.0  / items.length;
    }

    /**
     * copy  index head  to  head  + size
     */
    private void resize(int capacity) {
        Item[] a = (Item[])new Object[capacity];
        // lastindex  larger than items.length - 1
        // lastindex : head + size - 1 > items. length - 1
        if ( head + size - 1  > items.length -1   ) {
            // copy from  items[head] .. items[items.length -1 ]
            System.arraycopy(items,head, a,0, items.length - head );
            // copy from 0 to  last
            System.arraycopy(items, 0 , a, items.length - head, size + head - items.length);
        } else {
            System.arraycopy(items, head, a, 0 , size);
        }
        this.items = a;
        head = 0;
    }

    private void shrink() {
        int shrinkLength = items.length;
        while (size / shrinkLength < 0.25) {
            shrinkLength = shrinkLength / 2;
            if( shrinkLength <= 16 ) {
                break;
            }
        }

        if (shrinkLength < 16) {
            shrinkLength = 16;
        }

        resize(shrinkLength);
    }


    /*
    Adds an item to the front of the Deque.
     */
    public void addFirst(Item item) {
        if (items.length == size) {
            resize(items.length * 2);
        }
        if ( size == 0 ){
            items[0] = item;
            size = size + 1;
            head = 0;
            return;
        }

        head = (head - 1 + items.length) % items.length;
        items[head] = item;
        size = size + 1;
    }

    /*
    Adds an item to the back of the Deque.
     */
    public void addLast(Item item) {
        if (items.length == size) {
            resize(items.length * 2);
        }
        int index = (head + size) % items.length;
        items[index] = item;
        size = size + 1;
    }

    /*
    Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    : Returns the number of items in the Deque.
     */
    public int size() {
        return size;
    }

    /*
    Prints the items in the Deque from first to last, separated by a space.
     */
    public void printDeque() {
        for (Item i : items) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
    Removes and returns the item at the front of the Deque. If no such item exists, returns null.
     */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16 && usage() < 0.25) {
            shrink();
        }
        Item item = items[head];
        head = (head + 1) % items.length;
        size = size - 1;
        return item;
    }

    /*
    Removes and returns the item at the back of the Deque. If no such item exists, returns null.
     */
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length > 16 && usage() < 0.25) {
            shrink();
        }
        int lastIndex = (head + size - 1) % items.length;
        Item item = items[lastIndex];
        size = size - 1;
        return item;
    }

    /*
    Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     If no such item exists, returns null. Must not alter the deque!
     */
    public Item get(int index) {
        if (size == 0) {
            return null;
        }
        if ( index  > size - 1  || index < 0 ) {
            return null;
        }
        int realIndex;
        realIndex = ( head + index ) % items.length;
        return items[realIndex];
    }
}
