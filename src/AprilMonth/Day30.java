package AprilMonth;
/*
* A wonderful string is a string where at most one letter appears an odd number of times.
For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.
A substring is a contiguous sequence of characters in a string.
Example 1:
Input: word = "aba"
Output: 4
Explanation: The four wonderful substrings are underlined below:
- "aba" -> "a"
- "aba" -> "b"
- "aba" -> "a"
- "aba" -> "aba"
Example 2:
Input: word = "aabb"
Output: 9
Explanation: The nine wonderful substrings are underlined below:
- "aabb" -> "a"
- "aabb" -> "aa"
- "aabb" -> "aab"
- "aabb" -> "aabb"
- "aabb" -> "a"
- "aabb" -> "abb"
- "aabb" -> "b"
- "aabb" -> "bb"
- "aabb" -> "b"
Example 3:
Input: word = "he"
Output: 2
Explanation: The two wonderful substrings are underlined below:
- "he" -> "h"
- "he" -> "e"
Constraints:
1 <= word.length <= 105
word consists of lowercase English letters from 'a' to 'j'.
* */
class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Long> count = new HashMap<>();
        count.put(0, 1L); // Initialize with an empty string

        int bitmask = 0;
        long result = 0;

        for (char c : word.toCharArray()) {
            int bit = c - 'a';
            bitmask ^= 1 << bit;

            // Count substrings with at most one odd occurrence of a letter
            result += count.getOrDefault(bitmask, 0L);

            // Count substrings with one odd occurrence when flipping one bit
            for (int i = 0; i < 10; i++) {
                int flippedBitmask = bitmask ^ (1 << i);
                result += count.getOrDefault(flippedBitmask, 0L);
            }

            // Update the count for the current bitmask
            count.put(bitmask, count.getOrDefault(bitmask, 0L) + 1);
        }

        return result;
    }
}
public class Day30 {

}
