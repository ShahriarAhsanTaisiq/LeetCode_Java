package RegularPractice;

/* 1400. Construct K Palindrome Strings
* Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= 105

* */
class ConstructKPalindromeString {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        if(s.length() == k) return true;

        int oddCount = 0;
        for (char ch : s.toCharArray()) {
            oddCount ^= 1 << (ch - 'a');
        }
        return Integer.bitCount(oddCount) <= k;
    }
}
public class LeetCode1400 {
    public static void main(String[] args) {
        ConstructKPalindromeString solution = new ConstructKPalindromeString();
        System.out.println(solution.canConstruct(new String("annabelle"), 2));
        System.out.println(solution.canConstruct("leetcode", 3));
    }

}
