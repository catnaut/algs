import java.util.ArrayList;
import java.util.List;

public class ArrayBinaryTree {
    private List<Integer> tree;

    ArrayBinaryTree() {
        tree = new ArrayList<>();
    }


    public void init() {
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
    }

    public int size(){
        return tree.size();
    }

    public boolean isEmpty(){
        return tree.isEmpty();
    }

    public Integer get(int i){
        return tree.get(i);
    }

    public Integer left(int i){
        return tree.get(2*i+1);
    }

    public Integer right(int i){
        return tree.get(2*i+2);
    }

    public Integer parent(int i){
        return tree.get((i-1)/2);
    }

    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        // 直接遍历数组
        for (int i = 0; i < size(); i++) {
            if (get(i) != null)
                res.add(get(i));
        }
        return res;
    }
}
