package RegularPractice;

/* 476. Number Complement

* The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.Given an integer num, return its complement.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
Constraints:
1 <= num < 231
* */

class NumComplement{
    public int findComplement( int num ){
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
}
public class LeetCode476 {
    public static void main(String[] args) {
        // Create an instance of NumComplement class
        NumComplement numComplement = new NumComplement();
        // Test case 1
        int num1 = 5;
        int result1 = numComplement.findComplement(num1);
        System.out.println("Input: " + num1 + " | Complement: " + result1); // Expected output: 2
        // Test case 2
        int num2 = 1;
        int result2 = numComplement.findComplement(num2);
        System.out.println("Input: " + num2 + " | Complement: " + result2); // Expected output: 0
    }
}
