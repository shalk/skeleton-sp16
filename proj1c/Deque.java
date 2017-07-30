/**
 * Created by shalk on 2017/7/30.
 */
public interface Deque<Item> {
    //`: Adds an item to the front of the Deque.
    void addFirst(Item i);
    //`: Adds an item to the back of the Deque.
    void addLast(Item i);
    boolean isEmpty();
    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}
