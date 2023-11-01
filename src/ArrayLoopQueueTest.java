import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayLoopQueueTest {

    @Test
    public void testConstructor() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testCapacity() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        assertEquals(5, queue.capacity());
    }


    @Test
    public void testPushAndPeek() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(1, queue.peek());
    }

    @Test
    public void testPop() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
        assertEquals(3, queue.pop());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testPush_Full() {
        ArrayLoopQueue queue = new ArrayLoopQueue(2);
        queue.push(1);
        queue.push(2);
        Exception exception = assertThrows("push in a full queue", IndexOutOfBoundsException.class, () -> {
            queue.push(3);
        });
        String expectedMessage = "Queue is full";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPeek_Empty() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        Exception exception = assertThrows("peek in a empty queue", IndexOutOfBoundsException.class, () -> {
            queue.peek();
        });

        String expMS = "Queue is empty";
        String actMS = exception.getMessage();
        assertTrue(actMS.contains(expMS));
    }

    @Test
    public void testPopEmpty() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        Exception exception = assertThrows("pop in a empty queue", IndexOutOfBoundsException.class, () -> {
            queue.pop();
        });

        String expMS = "Queue is empty";
        String actMS = exception.getMessage();
        assertTrue(actMS.contains(expMS));
    }

    @Test
    public void testToArray() {
        ArrayLoopQueue queue = new ArrayLoopQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, queue.toArray());
    }
}