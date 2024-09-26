package RegularPractice;

/* 67. Add Binary
* Given two binary strings a and b, return their sum as a binary string.
Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
* */

class AddBinary{
    public String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
public class LeetCode67 {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        // Test Case 1
        String a1 = "11";
        String b1 = "1";
        System.out.println("Test Case 1:");
        System.out.println("a = " + a1 + ", b = " + b1);
        System.out.println("Output: " + addBinary.addBinary(a1, b1));  // Output: "100"
        System.out.println();

        // Test Case 2
        String a2 = "1010";
        String b2 = "1011";
        System.out.println("Test Case 2:");
        System.out.println("a = " + a2 + ", b = " + b2);
        System.out.println("Output: " + addBinary.addBinary(a2, b2));  // Output: "10101"
        System.out.println();

        // Additional Test Case
        String a3 = "1101";
        String b3 = "1110";
        System.out.println("Additional Test Case:");
        System.out.println("a = " + a3 + ", b = " + b3);
        System.out.println("Output: " + addBinary.addBinary(a3, b3));  // Output: "11011"

    }
}
