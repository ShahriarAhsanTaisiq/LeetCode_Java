package MayMonth;

import java.util.*;

/*131. Palindrome Partitioning
* Given a string s, partition s such that every
substring
 of the partition is a
palindrome
. Return all possible palindrome partitioning of s.
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
* */
class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
public class Day22 {
    public static void main(String[] args) {
        PalindromePartition solution = new PalindromePartition();

        // Test case 1
        String s1 = "aab";
        List<List<String>> result1 = solution.partition(s1);
        System.out.println("Test case 1: " + s1);
        for (List<String> partition : result1) {
            System.out.println(partition);
        }
        System.out.println();

        // Test case 2
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println("Test case 2: " + s2);
        for (List<String> partition : result2) {
            System.out.println(partition);
        }
        System.out.println();

        // Test case 3
        String s3 = "abba";
        List<List<String>> result3 = solution.partition(s3);
        System.out.println("Test case 3: " + s3);
        for (List<String> partition : result3) {
            System.out.println(partition);
        }
        System.out.println();

        // Test case 4
        String s4 = "racecar";
        List<List<String>> result4 = solution.partition(s4);
        System.out.println("Test case 4: " + s4);
        for (List<String> partition : result4) {
            System.out.println(partition);
        }
        System.out.println();
    }
}
