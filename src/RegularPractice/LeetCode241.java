package RegularPractice;
/* 241. Different Ways to Add Parentheses
* Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Constraints:
1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
* */

import java.util.*;

class DiffWayToAddParentheses{
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }

    private List<Integer> helper(String expr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char charAt = expr.charAt(i);
            if (charAt == '+' || charAt == '-' || charAt == '*') {
                List<Integer> left = helper(expr.substring(0, i));
                List<Integer> right = helper(expr.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (charAt == '+') {
                            result.add(l + r);
                        } else if (charAt == '-') {
                            result.add(l - r);
                        } else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expr));
        }
        return result;
    }
}
public class LeetCode241 {
    public static void main(String[] args) {
        DiffWayToAddParentheses solver = new DiffWayToAddParentheses();

        // Test case 1
        String expression1 = "2-1-1";
        List<Integer> result1 = solver.diffWaysToCompute(expression1);
        System.out.println("Input: " + expression1);
        System.out.println("Output: " + result1);
        System.out.println();

        // Test case 2
        String expression2 = "2*3-4*5";
        List<Integer> result2 = solver.diffWaysToCompute(expression2);
        System.out.println("Input: " + expression2);
        System.out.println("Output: " + result2);
        System.out.println();

        // Additional test case 3
        String expression3 = "3+2*2";
        List<Integer> result3 = solver.diffWaysToCompute(expression3);
        System.out.println("Input: " + expression3);
        System.out.println("Output: " + result3);
        System.out.println();
    }
}
