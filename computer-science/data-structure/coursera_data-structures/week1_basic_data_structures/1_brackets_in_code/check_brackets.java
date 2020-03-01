import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        // BufferedReader reader = new BufferedReader(input_stream);
        BufferedReader reader = new BufferedReader(new FileReader(
                "/Users/kimdonghwan/github/TIL/CS/Data Structure/coursera_data-structures/week1_basic_data_structures/1_brackets_in_code/tests/41"));
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();

        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.add(new Bracket(next, position + 1));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.isEmpty() == false) {
                    if (opening_brackets_stack.peek().Match(next)) {
                        opening_brackets_stack.pop();
                    } else {
                        opening_brackets_stack.add(new Bracket(next, position + 1));
                        break;
                    }
                } else {
                    opening_brackets_stack.add(new Bracket(next, position + 1));
                    break;
                }
            }
        }

        // Printing answer, write your code here

        if (opening_brackets_stack.isEmpty()) {
            System.out.println("Success");
        } else {
            System.out.println(opening_brackets_stack.peek().position);
        }
    }
}
