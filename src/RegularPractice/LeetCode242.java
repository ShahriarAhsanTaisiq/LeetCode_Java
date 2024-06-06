package RegularPractice;
/*242. Valid Anagram
*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
* */

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //    char [] sChar = s.toCharArray();
        //    char [] tChar = t.toCharArray();

        //    Arrays.sort(sChar);
        //    Arrays.sort(tChar);
        //    return Arrays.equals(sChar, tChar);

        // // Using Hash Table
        // HashMap<Character, Integer> count = new HashMap<>();

        // // Count s string frequency;
        // for (char x : s.toCharArray()) {
        //     count.put(x, count.getOrDefault(x, 0) + 1);
        // }
        // // Decrement the t string frequency
        // for (char x : t.toCharArray()) {
        //     count.put(x, count.getOrDefault(x, 0) - 1);
        // }

        // // Check char has non-zero frequency
        // for (int val : count.values()) {
        //     if (val != 0) {
        //         return false;
        //     }
        // }
        // return true;

        int [] store = new int[26];
        for(int i=0; i<s.length(); i++){
            store[s.charAt(i)-'a']++;
            store[t.charAt(i)-'a']--;
        }
        for(int val:store){
            if( val != 0){
                return false;
            }
        }
        return true;
    }
}
public class LeetCode242 {
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // Test case 1
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solution.isAnagram(s1, t1);
        System.out.println("Test case 1: " + result1); // Expected: true

        // Test case 2
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        System.out.println("Test case 2: " + result2); // Expected: false

        // Additional test cases
        String s3 = "listen";
        String t3 = "silent";
        boolean result3 = solution.isAnagram(s3, t3);
        System.out.println("Test case 3: " + result3); // Expected: true
    }
}
