package RegularPractice;

/*
* You are given a string s. You can convert s to a  palindrome by adding characters in front of it.
Return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:
Input: s = "abcd"
Output: "dcbabcd"

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.
* */
class ShortestPalindrome{
    public  String shortestPalindrome(String s){
        final String t = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < t.length(); i++){
            if (s.startsWith(t.substring(i))){
                return t.substring(0,i) + s;
            }
        }
        return t + s;
    }
}
public class LeetCode214 {
    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();

        // Test case 1
        String input1 = "aacecaaa";
        String output1 = sp.shortestPalindrome(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + output1);
        System.out.println("Expected: aaacecaaa");
        System.out.println();

        // Test case 2
        String input2 = "abcd";
        String output2 = sp.shortestPalindrome(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + output2);
        System.out.println("Expected: dcbabcd");
        System.out.println();

        // Additional Test case
        String input3 = "abc";
        String output3 = sp.shortestPalindrome(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output: " + output3);
        System.out.println("Expected: cbabc");
    }
}
