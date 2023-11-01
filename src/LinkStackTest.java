import org.junit.Test;
import static org.junit.Assert.*;

public class LinkStackTest {

    @Test
    public void testPushAndPop() {
        LinkStack stack = new LinkStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPeek() {
        LinkStack stack = new LinkStack();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        LinkStack stack = new LinkStack();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        LinkStack stack = new LinkStack();
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testToArray() {
        LinkStack stack = new LinkStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int[] expected = {3, 2, 1};
        assertArrayEquals(expected, stack.toArray());
    }
}