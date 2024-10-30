package RegularPractice;

/* 342. Power of Four
* Given an integer n, return true if it is a power of four. Otherwise, return false.
An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true

Constraints:
-231 <= n <= 231 - 1
* */

class PowerOfFour{
    public boolean isPowerOfFour( int n){
        if(n == 0) return false;
        if(n == 1) return true;

        if(n%4 == 0) return isPowerOfFour(n/4);
        return false;
    }
}
public class LeetCode342 {
    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();

        int[] testCases = {16, 5, 1, 64, 0, -4, 256, 1024};
        for (int n : testCases) {
            boolean result = powerOfFour.isPowerOfFour(n);
            System.out.println("Input: " + n + " -> Output: " + result);
        }
    }
}
