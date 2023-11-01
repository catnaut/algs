import java.util.EmptyStackException;
// import ds.LinkNode;

public class LinkStack{

    private LinkNode stackPeek;
    private int stackSize;

    public LinkStack() {
        stackPeek = null;
        stackSize = 0;
    }

    public int size() {
        return stackSize;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    public void push(int e) {
        LinkNode newNode = new LinkNode(e);
        newNode.next = stackPeek;
        stackPeek = newNode;
        stackSize++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackPeek.val;
    }

    public int pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int res = peek();
        LinkNode delNode = stackPeek;
        stackPeek = stackPeek.next;
        stackSize--;
        delNode.next = null; // help GC
        return res;
    }

    public int[] toArray(){
        int[] res = new int[size()];
        LinkNode node = stackPeek;
        for(int i = 0; i < size(); i++){
            res[i] = node.val;
            node = node.next;
        }
        return res;
    }
}