/**
 * Created by shalk on 2017/7/3.
 */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }

    }

    public static void test_array_deque_add() {
        boolean pass = true;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < 10000; i++)
            deque.addFirst(10);
        deque.addFirst(9);
        deque.addLast(13);

        pass = checkEmpty(false,deque.isEmpty()) && pass;
        pass = checkSize(10002,deque.size()) && pass;

        printTestStatus(pass);
    }

    public static void test_array_deque_remove() {
        boolean pass = true;
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < 64; i++)
            deque.addFirst(i);

        deque.removeFirst();
        deque.removeLast();

        pass = checkEmpty(false,deque.isEmpty()) && pass;
        pass = checkSize(62,deque.size()) && pass;
        pass = checkEmpty(true, deque.get(0) == 62)  && pass;

        pass = checkEmpty(true, deque.get(61) == 1) && pass;

        pass = checkEmpty(true, deque.get(62) == null) && pass;

        pass = checkEmpty(true, deque.get(-1) == null) && pass;

        printTestStatus(pass);
    }

    public static void main(String[] args) {

        test_array_deque_add();
        test_array_deque_remove();
    }
}
