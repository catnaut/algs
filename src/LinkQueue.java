public class LinkQueue {

    private LinkNode front,rear = null;
    private int queSize = 0;

    LinkQueue  () {
        // System.out.println("Hello, World");
    }

    public int size() {
        return queSize;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int x) {
        LinkNode node = new LinkNode(x);
        if (isEmpty()) {
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        queSize++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return front.val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int res = peek();
        front = front.next;
        queSize--;
        return res;
    }

    public int[] toArray() {
        int[] res = new int[queSize];
        LinkNode node = front;
        for (int i = 0; i < queSize; i++) {
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}
