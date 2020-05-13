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

    public TreeNode<E> findNode(E e, String input) {
        TreeNode<E> current = root;
        TreeNode<E> children = null;
        TreeNode<E> parent = null;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else if (e.compareTo(current.element) == 0) {
                children =  current;
                if (input.equals("child"))
                    return children;
                if (input.equals("parent"))
                    return parent;
            }
        }
        return null;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> deleteNode;
        TreeNode<E> parent;
        TreeNode<E> successorNode;

        deleteNode = findNode(e, "child");
        if (deleteNode == null)
            return true;

        if (deleteNode.left == null && deleteNode.right == null) {
            if (deleteNode == root) {
                root = null;
                return true;
            }

            parent = findNode(e, "parent");

            if (parent.left == deleteNode) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
            return true;
        }

        if (deleteNode.right == null) {
            if (deleteNode == root) {
                root = root.left;
                return true;
            }

            parent = findNode(e, "parent");

            if (parent.left == deleteNode) {
                parent.left = deleteNode.left;
            }
            else {
                parent.right = deleteNode.left;
            }
            return true;
        }

        if (deleteNode.left == null) {
            if (deleteNode == root) {
                root = root.right;
                return true;
            }

            parent = findNode(e, "parent");

            if ( parent.left == deleteNode )
                parent.left = deleteNode.right;
            else
                parent.right = deleteNode.right;

            return true;
        }

        if (deleteNode.right.left == null) {
            deleteNode.element = deleteNode.right.element;
            deleteNode.right = deleteNode.right.right;

            return true;
        }

        successorNode = deleteNode.right;
        TreeNode<E> successorNodeParent = deleteNode;

        while ( successorNodeParent.left != null ) {
            successorNodeParent = successorNode;
            successorNode = successorNode.left;
        }

        deleteNode.element = successorNode.element;
        successorNodeParent.left = successorNode.right;
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
        preOrder(root);
    }

    protected void preOrder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " | ");
        preOrder(root.left);
        preOrder(root.right);
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
