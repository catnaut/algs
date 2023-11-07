import java.util.ArrayList;
import java.util.List;

public class BaseHashMap extends HashMap {

    // private List<KeyPair> buckets;
    private KeyPair[] buckets;

    public BaseHashMap(int capacity){
        buckets = new KeyPair[capacity];
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = null;
        }

    }

    protected int hashFunc(int key) {
        return key % capacity;
    }

    protected int indexFor(int key) {
        // 基础的 HashMap 中，indexFor 和 hashFunc 是一样的
        return hashFunc(key);
    }


    public void put(int key,String value){
        // int index = hashFunc(key);
        int index = indexFor(key);


        KeyPair curPair = buckets[index];

        if (curPair == null) {
            KeyPair newPair = new KeyPair(key,value);
            buckets[index] = newPair;
        }
        else {
            // 因为没有考虑到 key 重复的情况，所以这里直接抛出异常
            throw new IllegalStateException("HashMap is full!");
        }

    }

    public String get(int key) {
        // int index = hashFunc(key);
        int index = indexFor(key);
        KeyPair curPair = buckets[index];
        if (curPair != null&&curPair.getKey()==key) {
            return curPair.getValue();
        }
        else {
            throw new IndexOutOfBoundsException("Key does not exist!");
        }
    }

    public void remove(int key) {
        // int index = hashFunc(key);
        int index = indexFor(key);
        KeyPair curPair = buckets[index];
        if (curPair != null&&curPair.getKey()==key) {
            // buckets.set(index,null);
            buckets[index] = null;
        }
        else {
            throw new IndexOutOfBoundsException("Key does not exist!");
        }
    }

    public List<KeyPair> pairSet() {
        // return buckets;
        List<KeyPair> list = new ArrayList<KeyPair>();
        for (int i = 0; i < capacity; i++) {
            if(buckets[i]!=null) list.add(buckets[i]);
        }
        return list;
    }

    public List<Integer> keySet() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                // list.add(buckets[i].getKey());
                if(buckets[i]!=null) list.add(buckets[i].getKey());
            }
        }
        return list;
    }

    public List<String> valueSet() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                // list.add(buckets[i].getValue());
                if(buckets[i]!=null) list.add(buckets[i].getValue());
            }
        }
        return list;
    }

}
