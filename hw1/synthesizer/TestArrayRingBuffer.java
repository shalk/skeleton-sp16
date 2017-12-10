package synthesizer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void someTest() {
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<String>(10);
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
        for (int i = 0 ; i < 10 ; i++ ) {
            arb.enqueue("nice");
        }
        assertTrue(arb.isFull());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testOutOfCapacity() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Ring buffer overflow");
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<String>(10);
        for (int i = 0 ; i < 10 ; i++ ) {
            arb.enqueue("nice");
        }
        arb.enqueue("full");
    }

    @Test
    public void testUnderflow() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Ring buffer underflow");
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<String>(10);
        arb.dequeue();
    }


    @Test
    public void testOp(){
        ArrayRingBuffer<String> arb = new ArrayRingBuffer<>(5);
        arb.enqueue("nice"); // nice,null, null, null,null
        arb.dequeue();    // null, null, null, null
        arb.enqueue("nice1");
        arb.enqueue("nice2");
        arb.enqueue("nice3");
        arb.enqueue("nice4");
        arb.enqueue("nice5"); // nice1, nice2, nice3, nice4, nice5
        arb.dequeue();
        arb.dequeue(); // null, null, nice3, nice4, nice5;
        arb.enqueue("nice6"); // nice6, null, nice3, nice4, nice5;
        assertEquals("nice3", arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
