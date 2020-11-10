import java.util.Scanner;

public class ExpressionTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node node = new Node();

        node.constructTree(scanner.nextLine());
        node.inorder();
        System.out.println(node.calculate());
    }
}
