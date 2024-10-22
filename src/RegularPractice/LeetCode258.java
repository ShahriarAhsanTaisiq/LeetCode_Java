package RegularPractice;
/* 258. Add Digits
* Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 231 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?
* */

class AddDigits{
    public int addDigits(int num){
        if ( num < 10){
            return num;
        }
        int ans = 0;
        while (num != 0){
            ans += (num%10);
            num /= 10;
        }
        return addDigits(ans);
    }
}
public class LeetCode258 {
    public static void main(String[] args) {
        AddDigits ad = new AddDigits();

        // Test case 1
        int num1 = 38;
        System.out.println("Input: " + num1);
        System.out.println("Output: " + ad.addDigits(num1));  // Expected Output: 2

        // Test case 2
        int num2 = 0;
        System.out.println("Input: " + num2);
        System.out.println("Output: " + ad.addDigits(num2));  // Expected Output: 0

        // Test case 3
        int num3 = 123;
        System.out.println("Input: " + num3);
        System.out.println("Output: " + ad.addDigits(num3));  // Expected Output: 6 (1+2+3 = 6)

        // Test case 4
        int num4 = 9999;
        System.out.println("Input: " + num4);
        System.out.println("Output: " + ad.addDigits(num4));  // Expected Output: 9

        // Test case 5
        int num5 = 1001;
        System.out.println("Input: " + num5);
        System.out.println("Output: " + ad.addDigits(num5));  // Expected Output: 2
    }
}
