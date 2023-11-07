import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class BaseHashMapTest {

    @Test
    public void testConstructor() {
        BaseHashMap map = new BaseHashMap(10);
        ArrayList<KeyPair> exceptedList = new ArrayList<KeyPair>();
        assertEquals(exceptedList,map.pairSet());
    }

    @Test
    public void testCapacity() {
        BaseHashMap map = new BaseHashMap(10);
        assertEquals(10, map.getCapacity());
    }

    @Test
    public void testPutAndGet() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(15, "fifteen");
        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertEquals("three", map.get(3));
        assertEquals("fifteen", map.get(15));
    }

    @Test
    public void testPut_full(){
        BaseHashMap map = new BaseHashMap(10);

        Exception exception = assertThrows("pop in a empty stack", IllegalStateException.class, () -> {
            for (int i = 0; i < 11; i++) {
                map.put(i, String.valueOf(i));
            }
        });

        String expectedMessage = "HashMap is full!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testPutDuplicateKey() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");

        Exception exception = assertThrows("pop in a empty stack", IllegalStateException.class, () -> {
            map.put(1, "one");
        });

        String expectedMessage = "HashMap is full!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetNonExistentKey() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        // try {
        //     map.get(2);
        //     fail("Expected RuntimeException not thrown");
        // } catch (RuntimeException e) {
        //     assertEquals("Key does not exist!", e.getMessage());
        // }
        Exception exception = assertThrows("pop in a empty stack", IndexOutOfBoundsException.class, () -> {
            map.get(2);
        });

        String expectedMessage = "Key does not exist!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testRemove() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals("one", map.get(1));
        assertEquals("two",map.get(2));
        assertEquals("three", map.get(3));

        map.remove(2);
        Exception exception = assertThrows("pop in a empty stack", IndexOutOfBoundsException.class, () -> {
            map.get(2);
        });

        String expectedMessage = "Key does not exist!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals("one", map.get(1));
        assertEquals("three", map.get(3));
    }

    @Test
    public void testPairSet() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(3, map.pairSet().size());
    }

    @Test
    public void testKeySet() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(3, map.keySet().size());
    }

    @Test
    public void testValueSet() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals(3, map.valueSet().size());
    }
}