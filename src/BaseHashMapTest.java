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
    public void testExtend(){
        BaseHashMap map = new BaseHashMap(10);
        assertEquals(10,map.getCapacity());

        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }

        assertEquals(20, map.getCapacity());
    }

    @Test
    public void testPutDuplicateKey() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        assertEquals("one", map.get(1));
        map.put(1,"one+");
        assertEquals("one+", map.get(1));
    }

    @Test
    public void testHashCollision() {
        BaseHashMap map = new BaseHashMap(10);
        map.put(1, "one");
        map.put(11, "eleven");
        assertEquals("one", map.get(1));
        assertEquals("eleven", map.get(11));
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