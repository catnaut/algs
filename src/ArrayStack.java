// import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayStack {

    private ArrayList<Integer> stack;

    ArrayStack() {
        // System.out.println("Hello, World");
        // arr = new Array[0];
        stack = new ArrayList<Integer>();
    }

    public int size () {
        return stack.size();
    }

    public boolean isEmpty () {
        return stack.size() == 0;
    }

    public void push (int x) {
        stack.add(x);
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.get(size()- 1);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.remove(size() - 1);
    }

    public Object[] toArray() {
        return stack.toArray();
    }
}
