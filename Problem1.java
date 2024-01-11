import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Reading the first integer containing the number of test queries
        int N = input.nextInt();
        // Initializing the maximum value (as well as few other global variables for ease of use later)
        int max = Integer.MIN_VALUE;
        int data, newData;
        Node element;
        // Initializing the stack.
        Stack<Node> stack = new Stack<Node>();
        // Read the query and perform the actions specified using Java Stack API
        // methods.

        // First, the method parses through the query list and goes until N number of queries.
        // It assigns the necessary variables (data for holding the query and newData for holding any potential elements that need to be pushed to the stack)
        // The program then pushes, pops, or prints depending on what integer was selected with a few if/else statements
        // If '3' was chosen to print the max value, the program iterates over the stack to find what the max value is, assigns it to the appropriate variable
        // then prints it out. 
        for (int i = 0; i < N; i++) {
            data = input.nextInt();
            if (data == 1) {
                newData = input.nextInt();
                element = new Node(newData);
                stack.push(element);
            }
            else if (data == 2) {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Integer.MIN_VALUE;
                }
            }
            else if (data == 3) {
                for (int j = 0; j < stack.size(); j++) {
                    if (max < stack.get(j).data) {
                        max = stack.get(j).data;
                    }
                }
                System.out.println(max);
            }
        }
    }
}

    class Node {
        int data;
        public Node(int data){
            this.data = data;
        }
    }    
