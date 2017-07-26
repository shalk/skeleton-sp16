import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shalk on 2017/7/25.
 */
public class TestLinkedListDeque1B {


    @Test
    public void testIsEmpty() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        Boolean expected = true;
        Boolean actual = deque.isEmpty();
        assertEquals("expeceted :" + expected + "\n" + "actual:" + actual, expected, actual);
    }

    @Test
    public void testSize() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        Integer expected = 0;
        Integer actual = deque.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddFirst() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        Integer expectedSize = 2000;
        for (int i = 0; i < expectedSize; i++) {
            deque.addFirst(i);
        }
        Integer actualSize = deque.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddLast() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        Integer expectedSize = 2000;
        for (int i = 0; i < expectedSize; i++) {
            deque.addLast(i);
        }
        Integer actualSize = deque.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGet() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        Integer SIZE = 1000;
        for (int i = 0; i < SIZE; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < SIZE; i++) {
            Integer actual = deque.get(i);
            Integer expected = i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testGet2() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
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
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        // [ 59 58 ... 2 1 0 ]
        for (int i = 0; i < 60; i++) {
            deque.addFirst(i);
        }

        int expectedSize = 60;
        for (int i = 0; i < 59; i++) {
            Integer actual = deque.removeFirst();
            expectedSize--;
            assertEquals(expectedSize, deque.size());
//            Integer actual = deque.get(0);
            Integer expected = 59 - i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testRemoveLast() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        // [ 0 1 2 ... 58 59]
        for (int i = 0; i < 60; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < 59; i++) {
            Integer actual = deque.removeLast();
            Integer expected = 59 - i;
            assertEquals(expected, actual);
            Integer expectedSize = 59 - i;
            Integer actualSize = deque.size();
            assertEquals(expectedSize, actualSize);
        }
    }

    @Test
    public void testGetRecur() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }
        for (int i = 0; i < 100; i++) {
            Integer actual = deque.getRecursive(i);
            Integer expected = i;
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testAddAndRemoveManyTime() {
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < 100000; i++) {
                deque.addFirst(i);
            }
            for (int i = 0; i < 100000; i++) {
                deque.removeFirst();
            }
        }
    }


    @Test
    public void testGetOutOfRange(){
        StudentLinkedListDeque<Integer> deque = new StudentLinkedListDeque<>();
        for(int i = 0; i < 10; i++) {
            deque.addFirst(1);
        }
        Integer expect = null;
        Integer actual = deque.get(15);
        // bugy here , get value out of range
        assertEquals(expect, actual);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestLinkedListDeque1B.class);
    }
}
