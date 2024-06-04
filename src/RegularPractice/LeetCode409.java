package RegularPractice;
/* 409 Longest Palindrome
* Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.
Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
* */
class LargestPalindrome {
    public int longestPalindrome(String s) {
        // Use an array to count the frequency of each character
        int[] charCount = new int[128]; // 128 covers all ASCII characters

        // Count each character in the string
        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        // Calculate the length of the longest palindrome
        for (int count : charCount) {
            if (count % 2 == 0) {
                length += count; // Add even counts fully
            } else {
                length += count - 1; // Add the largest even part of odd counts
                hasOdd = true; // Indicate there's at least one odd character
            }
        }

        // If there's at least one character with an odd count, we can place one odd character in the center
        if (hasOdd) {
            length++;
        }

        return length;
    }
}

public class LeetCode409 {
    public static void main(String[] args) {
        LargestPalindrome solution = new LargestPalindrome();

        // Test case 1
        String s1 = "abccccdd";
        int result1 = solution.longestPalindrome(s1);
        System.out.println("Input: " + s1);
        System.out.println("Output: " + result1); // Expected: 7

        // Test case 2
        String s2 = "a";
        int result2 = solution.longestPalindrome(s2);
        System.out.println("Input: " + s2);
        System.out.println("Output: " + result2); // Expected: 1

        // Test case 3
        String s3 = "bb";
        int result3 = solution.longestPalindrome(s3);
        System.out.println("Input: " + s3);
        System.out.println("Output: " + result3); // Expected: 2
    }
}
