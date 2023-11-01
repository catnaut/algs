public class ArrayLoopDQueue extends ArrayLoopQueue{

    ArrayLoopDQueue(int capacity) {
        super(capacity);
    }

    public int peekFirst() {
        return super.peek();
    }

    public int popFirst() {
        return super.pop();
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return queue[index(front + size -1)];
    }


    public int popLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int res = peekLast();
        size --;
        return res;
    }
}
