import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayLoopDQueueTest {

    @Test
    public void testPeekLast() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.push(1);
        queue.push(2);
        assertEquals(2, queue.peekLast());
        queue.push(3);
        assertEquals(3, queue.peekLast());
    }

    @Test
    public void testPopLast() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(3, queue.popLast());
        assertEquals(2, queue.popLast());
        assertEquals(1, queue.popLast());
    }

    @Test
    public void testPeekFirst() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peekFirst());
        queue.push(3);
        assertEquals(1, queue.peekFirst());
    }

    @Test
    public void testPopFirst() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.popFirst());
        assertEquals(2, queue.popFirst());
        assertEquals(3, queue.popFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekLast_Empty() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.peekLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopLast_Empty() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.popLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPush_Full() {
        ArrayLoopDQueue queue = new ArrayLoopDQueue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
    }

}