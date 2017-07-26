import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shalk on 2017/7/25.
 */
public class TestArrayDeque1B {


    @Test
    public void testIsEmpty() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        Boolean expected = true;
        Boolean actual = deque.isEmpty();
        assertEquals("expeceted :" + expected + "\n" + "actual:" + actual, expected, actual);
    }

    @Test
    public void testSize() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        Integer expected = 0;
        Integer actual = deque.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFirst() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            deque.addFirst(i);
        }
        assertEquals(30, deque.size());
    }

    @Test
    public void testAddLast() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            deque.addLast(i);
        }
        assertEquals(30, deque.size());
    }

    @Test
    public void testGet() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 30; i++) {
            Integer actual = deque.get(i);
            Integer expected = i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testGet2() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        // should be [ 29 28 .... 0]
        for (int i = 0; i < 30; i++) {
            deque.addFirst(i);
        }
        for (int i = 0; i < 30; i++) {
            Integer actual = deque.get(i);
            Integer expected = 29 - i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        for (int i = 0; i < 30; i++) {
            deque.addFirst(i);
        }
        int expectedSize = 30;
        for (int i = 0; i < 29; i++) {
            //  bugy in removeFirst() ; maybe resize for shrink;
            deque.removeFirst();
            expectedSize--;
            assertEquals(expectedSize, deque.size());
            Integer actual = deque.get(0);
            Integer expected = 28 - i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testGetOutOfRange(){
        StudentArrayDeque<Integer> deque = new StudentArrayDeque<>();
        for(int i = 0; i < 10; i++) {
            deque.addFirst(1);
        }
        Integer expect = null;
        Integer actual = deque.get(15);
        assertEquals(expect, actual);
    }


    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDeque1B.class);
    }
}
