package RegularPractice;
/*3110. Score of a String
* You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
Return the score of s.
Example 1:
Input: s = "hello"
Output: 13
Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
Example 2:
Input: s = "zaz"
Output: 50
Explanation:
The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
Constraints:
2 <= s.length <= 100
s consists only of lowercase English letters.
* */
class ScoreOfAString{
    public int scoreOfString(String s){
        int total = 0;
        for(int i = 0; i<s.length()-1; i++){
            total += Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return total;
    }
}
public class LeetCode3110 {
    public static void main(String[] args) {
        ScoreOfAString solution = new ScoreOfAString();

        // Test cases
        String test1 = "hello";
        String test2 = "zaz";
        String test3 = "abc";
        String test4 = "az";
        String test5 = "aaaaaaa";

        // Printing out results
        System.out.println("Score of \"" + test1 + "\": " + solution.scoreOfString(test1)); // Expected output: 13
        System.out.println("Score of \"" + test2 + "\": " + solution.scoreOfString(test2)); // Expected output: 50
        System.out.println("Score of \"" + test3 + "\": " + solution.scoreOfString(test3)); // Expected output: 2
        System.out.println("Score of \"" + test4 + "\": " + solution.scoreOfString(test4)); // Expected output: 25
        System.out.println("Score of \"" + test5 + "\": " + solution.scoreOfString(test5)); // Expected output: 0
    }
}
