import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayStackTest {


    @Test
    public void testConstructor() {
        ArrayStack stack = new ArrayStack();
        assertEquals("stack is empty",0, stack.size());
        // assertArrayEquals("", null, null, 0);
    }

    @Test
    public void testIsEmpty() {
        ArrayStack stack = new ArrayStack();
        assertTrue("stack is empty", stack.isEmpty());
    }

    @Test
    public void testPush() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("stack is not empty", 3, stack.size());
    }

    @Test
    public void testPop() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("last in first out 3", 3, stack.pop());
        assertEquals(2,stack.pop());
        assertEquals(1,stack.pop());
    }

    @Test
    public void testPop_Empty(){
        ArrayStack stack = new ArrayStack();

        Exception exception = assertThrows("pop in a empty stack", IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });

        String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPeek_Empty() {
        ArrayStack stack = new ArrayStack();

        Exception exception = assertThrows("peek in a empty stack", IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });

        String expectedMessage = "Stack is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testToArray() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Integer[] expected = {3, 2, 1};
        // 实现时使用的是 Array.toArray() 方法
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, stack.toArray());
    }

}
