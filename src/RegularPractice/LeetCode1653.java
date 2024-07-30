package RegularPractice;

/*1653. Minimum Deletions to Make String Balanced
* You are given a string s consisting only of characters 'a' and 'b'​​​​.
You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.
Return the minimum number of deletions needed to make s balanced
Example 1:
Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:
Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.
Constraints:
1 <= s.length <= 105
s[i] is 'a' or 'b'​​.

* */

class MinDelToStringBalanced{
    public int minimumDeletions(String s){
        int ans = 0, count = 0;
        for (char ch : s.toCharArray()){
            if (ch == 'b'){
                count++;
            } else if ( count > 0){
                ans++;
                count--;
            }
        }
        return ans;
    }
}
public class LeetCode1653 {
    public static void main(String[] args) {
        MinDelToStringBalanced solution = new MinDelToStringBalanced();

        // Test case 1
        String s1 = "aababbab";
        int result1 = solution.minimumDeletions(s1);
        System.out.println("Input: " + s1);
        System.out.println("Output: " + result1); // Expected: 2

        // Test case 2
        String s2 = "bbaaaaabb";
        int result2 = solution.minimumDeletions(s2);
        System.out.println("Input: " + s2);
        System.out.println("Output: " + result2); // Expected: 2

        // Additional test cases
        String s3 = "ababab";
        int result3 = solution.minimumDeletions(s3);
        System.out.println("Input: " + s3);
        System.out.println("Output: " + result3); // Expected: 3

        String s4 = "aaa";
        int result4 = solution.minimumDeletions(s4);
        System.out.println("Input: " + s4);
        System.out.println("Output: " + result4); // Expected: 0

        String s5 = "bbb";
        int result5 = solution.minimumDeletions(s5);
        System.out.println("Input: " + s5);
        System.out.println("Output: " + result5); // Expected: 0
    }
}
