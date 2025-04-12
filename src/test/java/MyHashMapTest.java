import org.finance_manegement.MyHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void testPutAndGet() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        assertEquals(Integer.valueOf(1), map.get("one"));
        assertEquals(Integer.valueOf(2), map.get("two"));
    }

    @Test
    public void testUpdateExistingKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("key", 10);
        map.put("key", 20);

        assertEquals(Integer.valueOf(20), map.get("key"));
    }

    @Test
    public void testRemove() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("removeMe", 100);
        Integer removedValue = map.remove("removeMe");

        assertEquals(Integer.valueOf(100), removedValue);
        assertNull(map.get("removeMe"));
    }

    @Test
    public void testSize() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertEquals(0, map.size());

        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());

        map.remove("one");
        assertEquals(1, map.size());
    }

    @Test
    public void testResize() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i, "value" + i);
        }

        assertEquals(20, map.size());
        assertEquals("value15", map.get(15));
    }

    @Test
    public void testNonExistentKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("exists", 42);

        assertNull(map.get("nonExistent"));
        assertNull(map.remove("nonExistent"));
    }
}