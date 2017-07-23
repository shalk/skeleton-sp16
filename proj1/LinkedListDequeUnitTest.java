import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by shalk on 2017/7/10.
 */
public class LinkedListDequeUnitTest {

    @Test
    public void testIsEmpty() {
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        boolean actual = deque.isEmpty();
        assertTrue(actual);
    }

    @Test
    public void testSize() {
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        assertEquals(0, deque.size());
    }

    @Test
    public void testAdd() {
        LinkedListDeque<String> deque = new LinkedListDeque<>();
        deque.addFirst("second");
        deque.addFirst("first");
//        deque.addLast("third");
//        deque.get(0);
    }
}
