package RegularPractice;
/*1190. Reverse Substrings Between Each Pair of Parentheses
* You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.

* */

class ReverseSubStringBtwParentheses{
    int i = 0;
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        return helper(arr);
    }

    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder();
        // int i = 0;
        while (i < s.length) {
            if (s[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s[i] == '(') {
                i++;
                String ch = helper(s);
                sb.append(ch);
            } else {
                sb.append(s[i]);
                i++;
            }

        }
        return sb.toString();
    }
}
public class LeetCode1190 {
    public static void main(String[] args) {
        ReverseSubStringBtwParentheses solver = new ReverseSubStringBtwParentheses();

        // Test case 1
        String s1 = "(abcd)";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solver.reverseParentheses(s1)); // Output: "dcba"

        // Test case 2
        String s2 = "(u(love)i)";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solver.reverseParentheses(s2)); // Output: "iloveu"

        // Test case 3
        String s3 = "(ed(et(oc))el)";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solver.reverseParentheses(s3)); // Output: "leetcode"

        // Test case 4
        String s4 = "a(bcdefghijkl(mno)p)q";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solver.reverseParentheses(s4)); // Output: "apmnolkjihgfedcbq"
    }
}
