import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeNodeTest {

    @Test
    public void testConstructor() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        assertEquals("node value is 1", 1, node.val);
        assertNull("left child is null", node.left);
        assertNull("right child is null", node.right);
    }

    @Test
    public void testSetLeft() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        node.setLeft(left);
        assertEquals("left child is 2", 2, node.left.val);
    }

    @Test
    public void testSetRight() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode right = new BinaryTreeNode(3);
        node.setRight(right);
        assertEquals("right child is 3", 3, node.right.val);
    }

    @Test
    public void testGetLeft() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        node.setLeft(left);
        assertEquals("left child is 2", 2, node.getLeft().val);
    }

    @Test
    public void testGetRight() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode right = new BinaryTreeNode(3);
        node.setRight(right);
        assertEquals("right child is 3", 3, node.getRight().val);
    }
}