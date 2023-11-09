import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ArrayBinaryTreeTest {

    @Test
    public void testConstructor() {
        ArrayBinaryTree tree = new ArrayBinaryTree();
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testLevelOrderTraversal(){
        ArrayBinaryTree tree = new ArrayBinaryTree();
        tree.init();
        List<Integer> result = tree.levelOrder();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(expected, result.toArray());
    }
}