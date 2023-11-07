import java.util.List;

public abstract class HashMap {

    protected int capacity;
    protected int size=0;
    protected float loadFactor = 0.75f;
    protected int extendRatio = 2; // 为了方便我设置为 2，防止出现浮点数

    public int getSize() {
        return this.size;
    }


    public int getCapacity() {
        return this.capacity;
    }

    protected abstract  void extendCapacity();

    protected abstract int hashFunc(int key);
    protected abstract int indexFor(int key);

    public abstract void put(int key, String value);
    public abstract String get(int key);
    public abstract void remove(int key);


    protected abstract List<KeyPair> pairSet();
    protected abstract List<Integer> keySet();
    protected abstract List<String> valueSet();

    public void print(){
        System.out.println("HashMap:");
        for (KeyPair keyPair : this.pairSet()) {
            if (keyPair != null) {
                System.out.printf("key: %d, value: %s\n", keyPair.getKey(), keyPair.getValue());
            }
        }
    }
}
