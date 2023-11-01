public class ArrayLoopQueue {
    protected int[] queue;
    // private int capacity;
    protected int size = 0;
    protected int front = 0;

    ArrayLoopQueue(int capacity) {
        // this.capacity = capacity;
        queue = new int[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == queue.length;
    }

    public int capacity() {
        return queue.length;
    }

    protected int index(int i) {
        return ( capacity() + i) % capacity();
    }

    public void push (int x) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        int rear = (front + size) % capacity();
        queue[rear] = x;
        size ++;
    }

    public int peek () {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return queue[front];
    }

    public int pop () {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int res = peek();
        // front = (front + 1) % capacity();
        front = index(front+1);
        size --;
        return res;
    }

    public int[] toArray() {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            // res[i] = queue[(front + i) % capacity()];
            res[i] = queue[index(front + i)];
        }
        return res;
    }
}
