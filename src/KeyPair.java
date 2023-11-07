public class KeyPair {
    // 类似于  Map.Entry<K,V>
    // 这个强行指定了 key 和 value 的类型


    public int key;
    public String value;

    KeyPair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void sstValue(String value)  {
        this.value = value;
    }

}