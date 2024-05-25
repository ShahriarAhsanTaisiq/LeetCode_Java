package MayMonth;

import java.util.*;

/*140. Word Break II
* Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:
Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
Constraints:
1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Input is generated in a way that the length of the answer doesn't exceed 105.

* */
class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Create a set for quick lookup of dictionary words
        Set<String> wordSet = new HashSet<>(wordDict);
        // Use a HashMap to memoize the results of subproblems
        return wordBreakHelper(s, wordSet, new HashMap<>());
    }

    private List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        // If we have already solved this subproblem, return the result from memo
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // List to store valid sentences formed from the current substring
        List<String> validSubstr = new ArrayList<>();

        // Base case: if the substring is empty, return an empty list (a valid segmentation)
        if (s.length() == 0) {
            validSubstr.add("");
            return validSubstr;
        }

        // Try every possible prefix of the current substring
        for (int end = 1; end <= s.length(); end++) {
            String prefix = s.substring(0, end);
            // If the prefix is in the dictionary, recursively solve for the suffix
            if (wordDict.contains(prefix)) {
                List<String> suffixes = wordBreakHelper(s.substring(end), wordDict, memo);
                for (String suffix : suffixes) {
                    validSubstr.add(prefix + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        // Memoize the result for the current substring
        memo.put(s, validSubstr);
        return validSubstr;
    }
}
public class Day25 {
    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();

        // Example 1
        String s1 = "catsanddog";
        List<String> wordDict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(solution.wordBreak(s1, wordDict1)); // Output: ["cats and dog", "cat sand dog"]

        // Example 2
        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(solution.wordBreak(s2, wordDict2)); // Output: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]

        // Example 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(solution.wordBreak(s3, wordDict3)); // Output: []
    }

}
