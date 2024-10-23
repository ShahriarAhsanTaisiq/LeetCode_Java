package RegularPractice;

/* 263. Ugly Number
* An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3
Example 2:
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.

Constraints:
-231 <= n <= 231 - 1
* */

class UglyNumber{
    public boolean isUgly(int num){
        if (num == 0){
            return false;
        }
        if (num > 0 && num <= 3){
            return true;
        }
        if (num % 2 == 0) return isUgly(num/2);
        if (num % 3 == 0) return isUgly(num/3);
        if (num % 5 == 0) return isUgly(num/5);
        return false;
    }
}
public class LeetCode263 {
    public static void main(String[] args) {
        // Create an instance of UglyNumber class
        UglyNumber uglyNumber = new UglyNumber();

        // Test cases
        int[] testCases = {6, 1, 14, 15, 30, 8, 9, 25, 14};

        // Iterate through the test cases and check if each number is an ugly number
        for (int n : testCases) {
            boolean result = uglyNumber.isUgly(n);
            System.out.println(n + " is " + (result ? "an ugly number." : "not an ugly number."));
        }
    }
}
