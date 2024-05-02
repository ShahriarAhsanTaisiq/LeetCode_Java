package MayMonth;
/*2000. Reverse Prefix of Word
* Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.
Example 1:
Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:
Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:
Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
Constraints:
1 <= word.length <= 250
word consists of lowercase English letters.
ch is a lowercase English letter.
* */
class ReversePrefixWord {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        return sb.reverse().append(word.substring(index + 1)).toString();
    }
}
public class Day1 {
    public static void main(String[] args) {
        ReversePrefixWord solution = new ReversePrefixWord();

        // Example 1
        String word1 = "abcdefd";
        char ch1 = 'd';
        System.out.println("Input: word = \"" + word1 + "\", ch = \"" + ch1 + "\"");
        System.out.println("Output: " + solution.reversePrefix(word1, ch1));

        // Example 2
        String word2 = "xyxzxe";
        char ch2 = 'z';
        System.out.println("\nInput: word = \"" + word2 + "\", ch = \"" + ch2 + "\"");
        System.out.println("Output: " + solution.reversePrefix(word2, ch2));

        // Example 3
        String word3 = "abcd";
        char ch3 = 'z';
        System.out.println("\nInput: word = \"" + word3 + "\", ch = \"" + ch3 + "\"");
        System.out.println("Output: " + solution.reversePrefix(word3, ch3));
    }
}
