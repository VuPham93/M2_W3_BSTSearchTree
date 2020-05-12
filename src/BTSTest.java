public class BTSTest {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.println("In order (sorted): ");
        tree.inOrder();

        System.out.println("\nPost order (sorted): ");
        tree.postOrder();

        System.out.println("\nPre order (sorted): ");
        tree.preOrder();

        System.out.println("\nThe number of nodes is: " + tree.getSize());

        System.out.print("Jones is in the tree?: ");
        System.out.println(tree.search("Jones"));

        System.out.print("John is in the tree?: ");
        System.out.println(tree.search("John"));

        System.out.print("Delete Daniel from the tree: ");
        tree.delete("Daniel");
        tree.preOrder();

        System.out.print("\nDelete Adam from the tree: ");
        tree.delete("Adam");
        tree.preOrder();

        System.out.print("\nDelete Tom from the tree: ");
        tree.delete("Tom");
        tree.preOrder();

        System.out.print("\nDelete George from the tree: ");
        tree.delete("George");
        tree.preOrder();
    }
}
