package RegularPractice;
/*14. Longest Common Prefix
* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
* */

class LongestCommonPrefix {
public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i =1; i<strs.length; i++){
        while(strs[i].indexOf(prefix) != 0){
        prefix = prefix.substring(0,prefix.length()-1);
        }
        }
        return prefix;
        }
        }
public class LeetCode14 {
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        // Test case 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix of " + String.join(", ", strs1) + ": " + solution.longestCommonPrefix(strs1));

        // Test case 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix of " + String.join(", ", strs2) + ": " + solution.longestCommonPrefix(strs2));

        // Test case 3
        String[] strs3 = {"interstellar", "internet", "interval"};
        System.out.println("Longest common prefix of " + String.join(", ", strs3) + ": " + solution.longestCommonPrefix(strs3));
    }
}
