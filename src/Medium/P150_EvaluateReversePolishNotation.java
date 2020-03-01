package Medium;

import java.util.Stack;

public class P150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first + second);
            } else if (token.equals("-")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first * second);
            } else if (token.equals("/")) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
