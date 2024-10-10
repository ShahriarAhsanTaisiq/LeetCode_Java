package RegularPractice;
/* 921. Minimum Add to Make Parentheses Valid
* A parentheses string is valid if and only if:
It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.
Example 1:
Input: s = "())"
Output: 1
Example 2:
Input: s = "((("
Output: 3
Constraints:
1 <= s.length <= 1000
s[i] is either '(' or ')'.
* */

class MinAddForValidParenTheses{
    public  int minAddToMakeValid( String s){
        int open = 0, misMatch = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                open++;
            } else {
                if (open > 0){
                    open--;
                } else{
                    misMatch++;
                }
            }
        }
        return open + misMatch;
    }
}
public class LeetCode921 {
    public static void main(String[] args) {
        MinAddForValidParenTheses solution = new MinAddForValidParenTheses();
        // Test case 1
        String s1 = "())";
        System.out.println("Input: " + s1);
        System.out.println("Minimum Additions to Make Valid: " + solution.minAddToMakeValid(s1)); // Output: 1

        // Test case 2
        String s2 = "(((";
        System.out.println("Input: " + s2);
        System.out.println("Minimum Additions to Make Valid: " + solution.minAddToMakeValid(s2)); // Output: 3

        // Additional test case 3
        String s3 = "()";
        System.out.println("Input: " + s3);
        System.out.println("Minimum Additions to Make Valid: " + solution.minAddToMakeValid(s3)); // Output: 0

        // Additional test case 4
        String s4 = "()))((";
        System.out.println("Input: " + s4);
        System.out.println("Minimum Additions to Make Valid: " + solution.minAddToMakeValid(s4)); // Output: 4
    }
}
