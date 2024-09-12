package RegularPractice;
/* 1684. Count the Number of Consistent Strings
* You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
Return the number of consistent strings in the array words.
Example 1:
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:
Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:
Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
Constraints:
1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.
* */

class NumOfConsistentString{
    public int countConsistentStrings(String allowed, String [] words){
        boolean [] freq = new boolean[26];
        int res = words.length;

        for (char ch : allowed.toCharArray()){
            freq[ch - 'a'] = true;
        }
        for (String word : words){
            for (char ch : word.toCharArray()){
                if (!freq[ch - 'a']){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
public class LeetCode1684 {
    public static void main(String[] args) {
        NumOfConsistentString solution = new NumOfConsistentString();

        // Test case 1
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        int result1 = solution.countConsistentStrings(allowed1, words1);
        System.out.println("Output for test case 1: " + result1); // Expected output: 2

        // Test case 2
        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        int result2 = solution.countConsistentStrings(allowed2, words2);
        System.out.println("Output for test case 2: " + result2); // Expected output: 7

        // Test case 3
        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        int result3 = solution.countConsistentStrings(allowed3, words3);
        System.out.println("Output for test case 3: " + result3); // Expected output: 4
    }
}
