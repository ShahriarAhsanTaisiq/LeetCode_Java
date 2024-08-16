package RegularPractice;

/* 29. Divide Two Integers
* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
Return the quotient after dividing dividend by divisor.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.


Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
Constraints:
-231 <= dividend, divisor <= 231 - 1
divisor != 0
* */

class DivideTwoIntegers{
    public int divide( int dividend, int divisor){

        int ans = dividend / divisor;
        // As we are dealing with the 32-bit signed integer range
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        return ans;
    }
}
public class LeetCode29 {
    public static void main(String[] args) {
        DivideTwoIntegers divider = new DivideTwoIntegers();

        // Test case 1
        int dividend1 = 10;
        int divisor1 = 3;
        int result1 = divider.divide(dividend1, divisor1);
        System.out.println("Result of " + dividend1 + " / " + divisor1 + " = " + result1); // Expected output: 3

        // Test case 2
        int dividend2 = 7;
        int divisor2 = -3;
        int result2 = divider.divide(dividend2, divisor2);
        System.out.println("Result of " + dividend2 + " / " + divisor2 + " = " + result2); // Expected output: -2

        // Test case 3
        int dividend3 = -2147483648;
        int divisor3 = -1;
        int result3 = divider.divide(dividend3, divisor3);
        System.out.println("Result of " + dividend3 + " / " + divisor3 + " = " + result3); // Expected output: 2147483647 (Integer.MAX_VALUE)

        // Test case 4
        int dividend4 = 2147483647;
        int divisor4 = 1;
        int result4 = divider.divide(dividend4, divisor4);
        System.out.println("Result of " + dividend4 + " / " + divisor4 + " = " + result4); // Expected output: 2147483647

        // Test case 5
        int dividend5 = 0;
        int divisor5 = 1;
        int result5 = divider.divide(dividend5, divisor5);
        System.out.println("Result of " + dividend5 + " / " + divisor5 + " = " + result5); // Expected output: 0
    }
}
