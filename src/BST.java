public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    protected void inOrder(TreeNode<E> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.element + " | ");
        inOrder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    protected void postOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " | ");
    }

    @Override
    public void preOrder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " | ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else if (e.compareTo(current.element) == 0)
                return true;
        }
        return false;
    }
}
