package RegularPractice;
/*2486. Append Characters to String to Make Subsequence
* You are given two strings s and t consisting of only lowercase English letters.
Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
Example 1:
Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
Example 2:
Input: s = "abcde", t = "a"
Output: 0
Explanation: t is already a subsequence of s ("abcde").
Example 3:
Input: s = "z", t = "abcde"
Output: 5
Explanation: Append the characters "abcde" to the end of s so that s = "zabcde".
Now, t is a subsequence of s ("zabcde").
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
Constraints:
1 <= s.length, t.length <= 105
s and t consist only of lowercase English letters.
* */
class AppendCharToStringMakeSeq {
    public int appendCharacters(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                tPointer++;
            }
            sPointer++;
        }

        return t.length() - tPointer;
    }
}
public class LeetCode2486 {
    public static void main(String[] args) {
        AppendCharToStringMakeSeq solution = new AppendCharToStringMakeSeq();

        // Test case 1
        String s1 = "coaching";
        String t1 = "coding";
        System.out.println("Test case 1: " + solution.appendCharacters(s1, t1)); // Output: 4

        // Test case 2
        String s2 = "abcde";
        String t2 = "a";
        System.out.println("Test case 2: " + solution.appendCharacters(s2, t2)); // Output: 0

        // Test case 3
        String s3 = "z";
        String t3 = "abcde";
        System.out.println("Test case 3: " + solution.appendCharacters(s3, t3)); // Output: 5
    }
}
