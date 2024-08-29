package RegularPractice;

/*191. Number of 1 Bits
* Write a function that takes the binary representation of a positive integer and returns the number of  set bits it has (also known as the Hamming weight).
Example 1:
Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.
Example 2:
Input: n = 128
Output: 1
Explanation:
The input binary string 10000000 has a total of one set bit.
Example 3:
Input: n = 2147483645
Output: 30
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
Constraints:

1 <= n <= 231 - 1
Follow up: If this function is called many times, how would you optimize it?
* */

class NumberOf1Bits{
    public int hammingWeight( int n){
        int count = 0;
        while ( n != 0 ){
            if ((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
public class LeetCode191 {
    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        // Test Case 1
        int n1 = 11; // Binary representation: 1011
        System.out.println("Input: " + n1 + " (Binary: " + Integer.toBinaryString(n1) + ")");
        System.out.println("Output: " + solution.hammingWeight(n1)); // Expected output: 3

        // Test Case 2
        int n2 = 128; // Binary representation: 10000000
        System.out.println("Input: " + n2 + " (Binary: " + Integer.toBinaryString(n2) + ")");
        System.out.println("Output: " + solution.hammingWeight(n2)); // Expected output: 1

        // Test Case 3
        int n3 = 2147483645; // Binary representation: 1111111111111111111111111111101
        System.out.println("Input: " + n3 + " (Binary: " + Integer.toBinaryString(n3) + ")");
        System.out.println("Output: " + solution.hammingWeight(n3)); // Expected output: 30
    }
}
