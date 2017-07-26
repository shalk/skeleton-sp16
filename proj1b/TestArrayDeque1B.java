import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

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
        // store fail seq
        ArrayDeque<String> fs = new ArrayDeque<>();

        int SIZE = 8;

        for (int i = 0; i < SIZE; i++) {
            deque.addFirst(i);
            fs.add("addFirst(" + i + ")");
        }

        for (int i = 0; i < SIZE; i++) {
            //  bugy in removeFirst() ; maybe resize for shrink;
            Integer actual = deque.removeFirst();
            fs.add("removeFirst()");
            Integer expected = SIZE - 1 - i;
            assertEquals("after OperationSequence" + fs.toString()+ "\nexpected be "+ expected+", but get " + actual ,expected, actual);
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
