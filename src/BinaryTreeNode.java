public class BinaryTreeNode extends TreeNode {
    BinaryTreeNode(int x) { super(x); }
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode getLeft() { return left; }
    BinaryTreeNode getRight() { return right; }
    void setLeft(BinaryTreeNode node) { left = node; }
    void setRight(BinaryTreeNode node) { right = node; }
}
