import org.junit.Test;
import static org.junit.Assert.*;

public class LinkNodeTest {

    @Test
    public void testConstructor() {
        LinkNode node = new LinkNode(1);
        assertEquals(1, node.val);
        assertNull(node.next);
    }

    @Test
    public void testSetNext() {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        node1.next = node2;
        assertEquals(node2, node1.next);
        assertEquals(2, node1.next.val);
    }

    // @Test
    // public void testNextVal(){
    //     LinkNode node1 = new LinkNode(1);
    //     LinkNode node2 = new LinkNode(2);
    //     node1.next = node2;
    // }
}