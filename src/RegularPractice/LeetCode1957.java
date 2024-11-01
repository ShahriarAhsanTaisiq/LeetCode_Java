package RegularPractice;
/* 1957. Delete Characters to Make Fancy String
* A fancy string is a string where no three consecutive characters are equal.
Given a string s, delete the minimum possible number of characters from s to make it fancy.
Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".

Constraints:
1 <= s.length <= 105
s consists only of lowercase English letters.
* */

class FancyString{
    public String makeFancyString( String  s){
        int count = 1;
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            } else{
                count = 1;
            }
            if (count < 3){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
public class LeetCode1957 {
    public static void main(String[] args) {
        FancyString fancyString = new FancyString();

        // Test cases
        String test1 = "leeetcode";
        System.out.println("Input: " + test1);
        System.out.println("Output: " + fancyString.makeFancyString(test1)); // Expected: "leetcode"

        String test2 = "aaabaaaa";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + fancyString.makeFancyString(test2)); // Expected: "aabaa"

        String test3 = "aab";
        System.out.println("Input: " + test3);
        System.out.println("Output: " + fancyString.makeFancyString(test3)); // Expected: "aab"
    }
}
