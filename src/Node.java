import java.util.ArrayList;

public class Node {
    String value;
    Node left, right;

    Node () {

    }

    Node (String input) {
        value = input;
    }

    void constructTree(String input) {
        if (input.contains("-")) {
            value = "-";
        } else if (input.contains("+")) {
            value = "+";
        } else if (input.contains("*")) {
            value = "*";
        } else if (input.contains("/")) {
            value = "/";
        } else if (input.contains("^")) {
            value = "^";
        } else {
            value = input;
            return;
        }

        String[] splittedInput = new String[]{input.substring(0, input.lastIndexOf(value)), input.substring(input.lastIndexOf(value) + 1)};
        left = new Node();
        left.constructTree(splittedInput[0]);
        right = new Node();
        right.constructTree(splittedInput[1]);
    }

    boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    int compute (char operator, int value1, int value2) {
        return switch (operator) {
            case '+' -> value1 + value2;
            case '-' -> value1 - value2;
            case '*' -> value1 * value2;
            case '/' -> value1 / value2;
            case '^' -> (int) Math.pow(value1, value2);
            default -> 0;
        };
    }

    void inorder() {
        if (left != null) {
            left.inorder();
        }
        System.out.println(value);
        if (right != null) {
            right.inorder();
        }
    }

    int calculate () {
        if (isOperator(value)) {
            return compute(value.charAt(0), left.calculate(), right.calculate());
        } else {
            return Integer.parseInt(value);
        }
    }
}
