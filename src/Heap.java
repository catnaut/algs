import java.util.List;

/**
 * 大顶堆
 */
public class Heap extends ArrayBinaryTree {

    public Heap() {
        super();
    }

    public Heap(List<Integer> list) {
        super();
        tree = list;
        for (int i = parentIndex(size() - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    @Override
    public void init() {
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
    }

    public Integer peek() {
        return tree.get(0);
    }

    /**
     * 元素入堆，放到最后
     */
    protected void push(int val) {
        tree.add(val);
    }

    /**
     * 通过index交换tree内的元素
     * 
     * @param a index
     * @param b index
     */
    private void swap(int a, int b) {
        Integer temp = get(a);
        tree.set(a, get(b));
        tree.set(b, temp);
    }

    /**
     * 从index开始向上堆化
     */
    protected void heapifyUp(int index) {
        int p = parentIndex(index);

        while (index > 0 && get(index) > get(p)) {
            swap(index, p);
            index = p;
            p = parentIndex(index);
        }
    }

    protected void heapifyDown(int index) {
        int leftIndex = leftIndex(index);
        int rightIndex = rightIndex(index);
        int maxIndex = index;
        if (leftIndex < size() && get(leftIndex) > get(maxIndex)) {
            maxIndex = leftIndex;
        }
        if (rightIndex < size() && get(rightIndex) > get(maxIndex)) {
            maxIndex = rightIndex;
        }
        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void offer(int val) {
        push(val);
        heapifyUp(size() - 1);
    }

    public Integer pop() {
        Integer top = peek();
        swap(0, size() - 1);
        tree.remove(size() - 1);
        heapifyDown(0);
        return top;
    }
}
