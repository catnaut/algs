import org.junit.Test;
import static org.junit.Assert.*;

public class LinkQueueTest {

    @Test
    public void testPushAndPop() {
        LinkQueue queue = new LinkQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }

    @Test
    public void testPeek() {
        LinkQueue queue = new LinkQueue();
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
        queue.push(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testPop_Empty() {
        LinkQueue queue = new LinkQueue();
        Exception exception = assertThrows("pop in a empty queue", IndexOutOfBoundsException.class, () -> {
            queue.pop();
        });

        String expectedMessage = "Queue is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPeek_Empty() {
        LinkQueue queue = new LinkQueue();
        Exception exception = assertThrows("peek in a empty queue", IndexOutOfBoundsException.class, () -> {
            queue.peek();
        });

        String expectedMessage = "Queue is empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testIsEmpty() {
        LinkQueue queue = new LinkQueue();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertFalse(queue.isEmpty());
        queue.pop();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        LinkQueue queue = new LinkQueue();
        assertEquals(0, queue.size());
        queue.push(1);
        assertEquals(1, queue.size());
        queue.push(2);
        assertEquals(2, queue.size());
        queue.pop();
        assertEquals(1, queue.size());
    }

    @Test
    public void testToArray() {
        LinkQueue queue = new LinkQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, queue.toArray());
    }
}