package RegularPractice;

/* 1545. Find Kth Bit in Nth Binary String
* Given two positive integers n and k, the binary string Sn is formed as follows:
S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.


Example 1:
Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:
Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".
Constraints:
1 <= n <= 20
1 <= k <= 2n - 1
* */

class FindKthBitInNBinaryString{
    public char findKthBit( int n, int k){
        if (n == 1){
            return '0';
        }
        int length = (1 << n) - 1;
        int mid = length/2 + 1;
        if (k == mid){
            return '1';
        }
        if (k < mid){
            return findKthBit(n-1, k);
        }
        return findKthBit(n-1, length-k+1) == '0' ? '1': '0';
    }
}
public class LeetCode1545 {
    public static void main(String[] args) {
        // Create an instance of the class
        FindKthBitInNBinaryString solution = new FindKthBitInNBinaryString();

        // Define values for n and k
        int n = 3; // Example value for n
        int k = 1; // Example value for k

        // Call the findKthBit method and display the result
        char result = solution.findKthBit(n, k);
        System.out.println("The " + k + "th bit in S" + n + " is: " + result);

        // You can change the values of n and k for further testing
        n = 4;
        k = 11;
        result = solution.findKthBit(n, k);
        System.out.println("The " + k + "th bit in S" + n + " is: " + result);
    }
}