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

    protected void extendCapacity(){
        KeyPair[] newBuckets = new KeyPair[capacity*extendRatio];
        // 注意扩容后，需要重新计算 index
        List<KeyPair> originPairSet =  pairSet();
        capacity = capacity*extendRatio; // 因为 pairSet() 中会遍历 buckets，所以不能再前面更新 capacity
        for (KeyPair keyPair : originPairSet) {
            int index = indexFor(keyPair.getKey());
            newBuckets[index] = keyPair;
        }
        buckets = newBuckets;
    }

    protected double getLoadFactor() {
        return (double) size / capacity;
    }

    protected void checkIfExtend() {
        if (getLoadFactor() > loadFactor) {
            extendCapacity();
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
        checkIfExtend();
        int index = indexFor(key);


        KeyPair curPair = buckets[index];

        if (curPair == null) {

            KeyPair newPair = new KeyPair(key,value);
            buckets[index] = newPair;
            size++;
        }
        else if(curPair.getKey()==key){
            // 如果 key 已经存在，就更新 value
            buckets[index].setValue(value);
        }
        else {
            // 需要扩容
            extendCapacity();
            // 递归调用在扩容后的数组重新put 此时不会触发扩容（应该
            put(key,value);
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
            size--;
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
