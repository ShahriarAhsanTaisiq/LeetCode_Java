package MayMonth;
/*1404. Number of Steps to Reduce a Number in Binary Representation to One
* Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
If the current number is even, you have to divide it by 2.
If the current number is odd, you have to add 1 to it.
It is guaranteed that you can always reach one for all test cases.
Example 1:
Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14.
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.
Step 5) 4 is even, divide by 2 and obtain 2.
Step 6) 2 is even, divide by 2 and obtain 1.
Example 2:
Input: s = "10"
Output: 1
Explanation: "10" corressponds to number 2 in their decimal representation.
Step 1) 2 is even, divide by 2 and obtain 1.
Example 3:
Input: s = "1"
Output: 0
Constraints:
1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
* */
class BinaryRepresentationToOne {
    public int numSteps(String s) {
        // Convert the string to a StringBuilder for easier manipulation
        StringBuilder binary = new StringBuilder(s);
        int steps = 0;

        // Loop until the binary string is reduced to "1"
        while (!binary.toString().equals("1")) {
            if (binary.charAt(binary.length() - 1) == '0') {
                // If the number is even (last bit is '0'), divide by 2 (remove the last bit)
                binary.deleteCharAt(binary.length() - 1);
            } else {
                // If the number is odd (last bit is '1'), add 1
                int i = binary.length() - 1;
                while (i >= 0 && binary.charAt(i) == '1') {
                    binary.setCharAt(i, '0');
                    i--;
                }
                if (i >= 0) {
                    binary.setCharAt(i, '1');
                } else {
                    binary.insert(0, '1');
                }
            }
            steps++;
        }

        return steps;
    }
}

public class Day29 {
    public static void main(String[] args) {
        BinaryRepresentationToOne solution = new BinaryRepresentationToOne();

        // Test case 1: Example 1
        String s1 = "1101";
        int result1 = solution.numSteps(s1);
        System.out.println("Input: " + s1 + ", Output: " + result1); // Expected output: 6

        // Test case 2: Example 2
        String s2 = "10";
        int result2 = solution.numSteps(s2);
        System.out.println("Input: " + s2 + ", Output: " + result2); // Expected output: 1

        // Test case 3: Example 3
        String s3 = "1";
        int result3 = solution.numSteps(s3);
        System.out.println("Input: " + s3 + ", Output: " + result3); // Expected output: 0

    }
}

