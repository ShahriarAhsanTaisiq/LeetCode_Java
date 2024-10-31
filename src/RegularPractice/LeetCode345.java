package RegularPractice;

/* 345. Reverse Vowels of a String
* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

* */

class RevVowelsOfString{
    public String reversVowels(String s){
        char [] word = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        String vowels = "AEIOUaeiou";

        while (start < end){
            while (start < end && vowels.indexOf(word[start]) == -1){
               start++;
            }
            while (start < end && vowels.indexOf(word[end]) == -1){
                end--;
            }
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
        }
        String ans = new String(word);
        return  ans;
    }
}
public class LeetCode345 {
    public static void main(String[] args) {
        // Create an instance of RevVowelsOfString
        RevVowelsOfString revVowels = new RevVowelsOfString();

        // Test case 1
        String input1 = "IceCreAm";
        String result1 = revVowels.reversVowels(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: AceCreIm\n");

        // Test case 2
        String input2 = "leetcode";
        String result2 = revVowels.reversVowels(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: leotcede\n");

        // Additional test cases
        String input3 = "aA";
        String result3 = revVowels.reversVowels(input3);
        System.out.println("Input: " + input3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: Aa\n");

        String input4 = "hello";
        String result4 = revVowels.reversVowels(input4);
        System.out.println("Input: " + input4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: holle\n");
    }
}
