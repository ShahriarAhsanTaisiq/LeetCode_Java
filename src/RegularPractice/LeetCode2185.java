package RegularPractice;

/* 2185. Counting Words With a Given Prefix
* You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.

Constraints:

1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] and pref consist of lowercase English letters.

* */

class CountWordsWithPrefix{
    public int countPrefix(String [] words, String pref){
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}

public class LeetCode2185 {
    public static void main(String[] args) {
        CountWordsWithPrefix obj = new CountWordsWithPrefix();
        System.out.println(obj.countPrefix(new String[]{"pay","attention","practice","attend"},"at"));
        System.out.println(obj.countPrefix(new String[]{"leetcode","win","loops","success"},"code"));
        System.out.println(obj.countPrefix(new String[]{"code","wincode","loops","success"},"code"));
    }
}
