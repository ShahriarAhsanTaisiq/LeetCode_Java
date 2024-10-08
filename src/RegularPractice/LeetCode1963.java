package RegularPractice;

/*1963. Minimum Number of Swaps to Make the String Balanced
* You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
A string is called balanced if and only if:
It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.
Return the minimum number of swaps to make s balanced.
Example 1:
Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
Example 2:
Input: s = "]]][[["
Output: 2
Explanation: You can do the following to make the string balanced:
- Swap index 0 with index 4. s = "[]][][".
- Swap index 1 with index 5. s = "[[][]]".
The resulting string is "[[][]]".
Example 3:
Input: s = "[]"
Output: 0
Explanation: The string is already balanced.
Constraints:
n == s.length
2 <= n <= 106
n is even.
s[i] is either '[' or ']'.
The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
* */

import java.util.Stack;

class MinSwapForBalancedString{
    public  int minSwap(String s){
        Stack<Character> stack = new Stack<>();
        int close = 0;
        for (char ch: s.toCharArray()){
            if (ch == '['){
                stack.push(ch);
            } else if (ch == ']') {
                if (!stack.isEmpty()){
                    stack.pop();
                } else{
                    close++;
                }
            }
        }
        return (close + 1) / 2;
    }
}
public class LeetCode1963 {
    public static void main(String[] args) {
        // Create an instance of the solution class
        MinSwapForBalancedString solution = new MinSwapForBalancedString();

        // Test case 1
        String s1 = "][][";
        System.out.println("Input: " + s1 + " -> Output: " + solution.minSwap(s1)); // Expected output: 1

        // Test case 2
        String s2 = "]]][[[";
        System.out.println("Input: " + s2 + " -> Output: " + solution.minSwap(s2)); // Expected output: 2

        // Test case 3
        String s3 = "[]";
        System.out.println("Input: " + s3 + " -> Output: " + solution.minSwap(s3)); // Expected output: 0

        // Test case 4 (Custom test case)
        String s4 = "[]][[]";
        System.out.println("Input: " + s4 + " -> Output: " + solution.minSwap(s4)); // Expected output: 1

        // Test case 5 (Edge case)
        String s5 = "[[[[]]]]";
        System.out.println("Input: " + s5 + " -> Output: " + solution.minSwap(s5)); // Expected output: 0
    }
}
