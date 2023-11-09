import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {

    private BinaryTreeNode root;

    BinaryTree() {
        root = null;
    }


    BinaryTreeNode getRootNode() {
        return root;
    }
    /**
    为了方便测试，提供了一个初始化的方法
    **/
    public void init(){
        root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.left.setLeft(new BinaryTreeNode(4));
        root.left.setRight(new BinaryTreeNode(5));
        root.right.setLeft(new BinaryTreeNode(6));
        root.right.setRight(new BinaryTreeNode(7));
    }


    static public List<Integer>  levelOrderTraversal(BinaryTreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        BinaryTreeNode cur = root;
        while (cur != null) {
            result.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            cur = queue.poll();
        }
        return result;
    }

    /** 使用栈模拟了递归 实现了先序遍历 **/
    static public List<Integer>  preOrderTraversal(BinaryTreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode cur = root;
        while (cur != null) {
            result.add(cur.val);
            if (cur.right != null) stack.push(cur.right); // 由于栈是先进后出，所以先将右子树压入栈中
            if (cur.left != null) stack.push(cur.left);
            // cur = stack.pop();
            cur = stack.isEmpty() ? null : stack.pop();
        }
        return result;
    }
}
