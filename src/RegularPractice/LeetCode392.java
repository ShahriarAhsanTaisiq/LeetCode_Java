package RegularPractice;
/*392. Is Subsequence
* Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
* */
class Subsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
            }
            j += 1;
        }
        if (i == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}

public class LeetCode392 {
    public static void main(String[] args) {
    Subsequence solution = new Subsequence();

    // Test case 1
    String s1 = "abc";
    String t1 = "ahbgdc";
        System.out.println("Test case 1: "+solution.isSubsequence(s1,t1)); // Expected output: true

    // Test case 2
    String s2 = "axc";
    String t2 = "ahbgdc";
        System.out.println("Test case 2: "+solution.isSubsequence(s2,t2)); // Expected output: false

    // Additional test case 3
    String s3 = "";
    String t3 = "ahbgdc";
        System.out.println("Test case 3: "+solution.isSubsequence(s3,t3)); // Expected output: true
    }
}
