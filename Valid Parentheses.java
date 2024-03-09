import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();

                if (ch == ')' && openBracket != '(' ||
                    ch == '}' && openBracket != '{' ||
                    ch == ']' && openBracket != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        System.out.println(solution.isValid("()"));         // Output: true
        System.out.println(solution.isValid("()[]{}"));     // Output: true
        System.out.println(solution.isValid("(]"));         // Output: false
    }
}
