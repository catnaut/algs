import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class HeapTest {

    @Test
    public void testConstructor() {
        Heap heap = new Heap();
        heap.init();
        assertEquals(5, heap.size());
        assertEquals(Integer.valueOf(5), heap.peek());
    }

    @Test
    public void testHeapifyUp() {

        Heap heap = new Heap();
        heap.init();
        heap.push(3);
        heap.heapifyUp(heap.size() - 1);
        assertEquals(Integer.valueOf(5), heap.peek());
        heap.push(10);
        heap.heapifyUp(heap.size() - 1);
        assertEquals(Integer.valueOf(10), heap.peek());
        heap.push(0);
        heap.heapifyUp(heap.size() - 1);
        assertEquals(Integer.valueOf(10), heap.peek());
    }

    @Test
    public void testOffer() {
        Heap heap = new Heap();
        heap.offer(6);
        assertEquals(Integer.valueOf(6), heap.peek());
        heap.offer(0);
        assertEquals(Integer.valueOf(6), heap.peek());
        heap.offer(10);
        assertEquals(Integer.valueOf(10), heap.peek());
    }

    @Test
    public void testHeapifyDown() {
        Heap heap = new Heap();
        heap.push(4);
        heap.push(5);
        heap.push(3);
        heap.push(2);
        heap.push(10);
        heap.heapifyDown(0);
        assertEquals(Integer.valueOf(5), heap.peek());
        heap.heapifyDown(0);
        assertEquals(Integer.valueOf(10), heap.peek());
    }

    @Test
    public void testPop() {
        Heap heap = new Heap();
        heap.init();
        assertEquals(Integer.valueOf(5), heap.pop());
        assertEquals(Integer.valueOf(4), heap.pop());
        assertEquals(Integer.valueOf(3), heap.pop());
        assertEquals(Integer.valueOf(2), heap.pop());
        assertEquals(Integer.valueOf(1), heap.pop());
        assertEquals(0, heap.size());
    }

    @Test
    public void testQuickConstructor() {
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        Heap heap = new Heap(list);
        assertEquals(list.size(), heap.size());
        assertEquals(Integer.valueOf(9), heap.peek());
    }
}