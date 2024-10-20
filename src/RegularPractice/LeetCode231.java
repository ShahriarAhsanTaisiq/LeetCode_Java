package RegularPractice;

/* 231. Power of Two
* Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:
Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:
Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:
Input: n = 3
Output: false

Constraints:

-231 <= n <= 231 - 1

Follow up: Could you solve it without loops/recursion?
* */

class PowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        for( long i = 0; i <= n; i++){
            long power = (long) Math.pow(2,i);
            if(power == n){
                return true;
            }
            if( power > n){
                return false;
            }
        }
        return false;
    }
}
public class LeetCode231 {
    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();

        // Test cases
        int[] testCases = {1, 16, 3, 1024, 0, -16};

        for (int testCase : testCases) {
            boolean result = powerOfTwo.isPowerOfTwo(testCase);
            System.out.println("Is " + testCase + " a power of two (Ture/False) :" + result);
        }
    }
}
