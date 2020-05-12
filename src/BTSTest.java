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
    }
}
