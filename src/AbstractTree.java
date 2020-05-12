public class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public boolean delete(E e) {
        return false;
    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void preOrder() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean search(E e) {
        return false;
    }
}