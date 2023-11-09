import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testInit() {
        BinaryTree tree = new BinaryTree();
        tree.init();
        BinaryTreeNode root = tree.getRootNode();
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.right.val);
        assertEquals(4, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(6, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }

    @Test
    public void testLevelOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.init();
        BinaryTreeNode root = tree.getRootNode();
        List<Integer> result = BinaryTree.levelOrderTraversal(root);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testPreOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.init();
        BinaryTreeNode root = tree.getRootNode();
        List<Integer> result = BinaryTree.preOrderTraversal(root);
        Integer[] expected = {1, 2, 4, 5, 3, 6, 7};
        assertArrayEquals(expected, result.toArray());
    }
}