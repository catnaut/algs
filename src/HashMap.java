import java.util.List;

public abstract class HashMap {

    protected int capacity;


    public int getCapacity() {
        return this.capacity;
    }

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
