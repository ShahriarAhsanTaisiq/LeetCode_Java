package AprilMonth;

/*2370. Longest Ideal Subsequence
*
* You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
Example 1:
Input: s = "acfgbd", k = 2
Output: 4
Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
Example 2:

Input: s = "abcd", k = 3
Output: 4
Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
Constraints:
1 <= s.length <= 105
0 <= k <= 25
s consists of lowercase English letters.
* */
class LongestIdeal {
    public int longestIdealString(String s, int k) {
        // dp[i] := the longest subsequence that ends in ('a' + i)
        int[] dp = new int[26];
        int maxReachable = 0;

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            dp[i] = 1 + getMaxReachable(dp, i, k);
            maxReachable = Math.max(maxReachable, dp[i]);
        }

        return maxReachable;
    }

    private int getMaxReachable(int[] dp, int i, int k) {
        int first = Math.max(0, i - k);
        int last = Math.min(25, i + k);
        int maxReachable = 0;
        for (int j = first; j <= last; j++)
            maxReachable = Math.max(maxReachable, dp[j]);
        return maxReachable;
    }
}

public class Day25 {
    public static void main(String[] args) {
        LongestIdeal solution = new LongestIdeal();

        // Test cases
        String s1 = "acfgbd";
        int k1 = 2;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: " + solution.longestIdealString(s1, k1)); // Expected output: 4

        String s2 = "abcd";
        int k2 = 3;
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: " + solution.longestIdealString(s2, k2)); // Expected output: 4

        // Additional test cases
        String s3 = "abdefg";
        int k3 = 1;
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: " + solution.longestIdealString(s3, k3)); // Expected output: 5

        String s4 = "zx";
        int k4 = 25;
        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        System.out.println("Output: " + solution.longestIdealString(s4, k4)); // Expected output: 2
    }
}
