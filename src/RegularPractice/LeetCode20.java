package RegularPractice;
/*20. Valid Parentheses
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
* */
import java.util.Stack;

class ValidParentheses{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch :  s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }
            else if (ch == '{'){
                stack.push('}');
            }
            else if (ch == '['){
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.pop() != ch){
                return  false;
            }
        }
    return stack.isEmpty();
    }
}
public class LeetCode20 {
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Test cases
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[]}";
        String test6 = ""; // Edge case: empty string
        String test7 = "["; // Edge case: single character
        String test8 = "([])"; // Nested valid

        // Print results
        System.out.println("Test 1: " + solution.isValid(test1)); // Expected: true
        System.out.println("Test 2: " + solution.isValid(test2)); // Expected: true
        System.out.println("Test 3: " + solution.isValid(test3)); // Expected: false
        System.out.println("Test 4: " + solution.isValid(test4)); // Expected: false
        System.out.println("Test 5: " + solution.isValid(test5)); // Expected: true
        System.out.println("Test 6: " + solution.isValid(test6)); // Expected: true
        System.out.println("Test 7: " + solution.isValid(test7)); // Expected: false
        System.out.println("Test 8: " + solution.isValid(test8)); // Expected: true
    }
}
