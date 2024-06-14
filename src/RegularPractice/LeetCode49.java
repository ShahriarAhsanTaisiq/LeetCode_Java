package RegularPractice;

import java.util.*;

/*
* 49. Group Anagrams
*Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]
Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
* */
class GroupsOfAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
public class LeetCode49 {
    public static void main(String[] args) {
        GroupsOfAnagram solution = new GroupsOfAnagram();

        // Example 1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Example 1 Output: " + solution.groupAnagrams(strs1));

        // Example 2
        String[] strs2 = {""};
        System.out.println("Example 2 Output: " + solution.groupAnagrams(strs2));

        // Example 3
        String[] strs3 = {"a"};
        System.out.println("Example 3 Output: " + solution.groupAnagrams(strs3));
    }
}
