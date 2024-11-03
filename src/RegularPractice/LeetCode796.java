package RegularPractice;

/* 796. Rotate String
* Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

* */

class RotateString{

    /*
    * Explanation

	1.	Concatenating the String:
	•	By concatenating s with itself (s + s), we get a new string that contains all possible rotations of s.
	•	For example, if s = "abcde", then s + s = "abcdeabcde". Any rotation of s, such as "deabc", will be a substring of "abcdeabcde".
	2.	Checking for Rotation:
	•	The contains(goal) method checks if goal is a substring of s + s. If goal is indeed a rotation of s, then goal should appear within this doubled string.
	3.	Length Check:
	•	Additionally, we check if the lengths of s and goal are equal. If s and goal have different lengths, they cannot be rotations of each other, so we return false.
    * */
    public boolean rotateString( String s, String goal){
        return (s+s).contains(goal) && s.length() == goal.length();
    }
}
public class LeetCode796 {
    public static void main(String[] args) {
        RotateString solution = new RotateString();

        // Test cases
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Test case 1: " + solution.rotateString(s1, goal1)); // Expected output: true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Test case 2: " + solution.rotateString(s2, goal2)); // Expected output: false

        String s3 = "a";
        String goal3 = "a";
        System.out.println("Test case 3: " + solution.rotateString(s3, goal3)); // Expected output: true

        String s4 = "abc";
        String goal4 = "acb";
        System.out.println("Test case 4: " + solution.rotateString(s4, goal4)); // Expected output: false

        String s5 = "rotation";
        String goal5 = "tationro";
        System.out.println("Test case 5: " + solution.rotateString(s5, goal5)); // Expected output: true
    }
}
