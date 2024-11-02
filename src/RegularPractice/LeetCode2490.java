package RegularPractice;

/* 2490. Circular Sentence
* A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.
For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.



Example 1:

Input: sentence = "leetcode exercises sound delightful"
Output: true
Explanation: The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
- leetcode's last character is equal to exercises's first character.
- exercises's last character is equal to sound's first character.
- sound's last character is equal to delightful's first character.
- delightful's last character is equal to leetcode's first character.
The sentence is circular.
Example 2:

Input: sentence = "eetcode"
Output: true
Explanation: The words in sentence are ["eetcode"].
- eetcode's last character is equal to eetcode's first character.
The sentence is circular.
Example 3:

Input: sentence = "Leetcode is cool"
Output: false
Explanation: The words in sentence are ["Leetcode", "is", "cool"].
- Leetcode's last character is not equal to is's first character.
The sentence is not circular.


Constraints:

1 <= sentence.length <= 500
sentence consist of only lowercase and uppercase English letters and spaces.
The words in sentence are separated by a single space.
There are no leading or trailing spaces.

* */

class CircularSentence{
    public boolean isCircularSentence(String sentence){
        String [] str = sentence.split(" ");
        if (str.length == 1){
            if (str[0].charAt(0) == str[0].charAt(str[0].length() - 1)){
                return true;
            }
        }
        for (int i = 1; i < str.length; i++){
            if (str[i-1].charAt(str[i-1].length()-1) != str[i].charAt(0)){
                return false;
            }
        }
        return str[0].charAt(0) == str[str.length - 1].charAt(str[str.length - 1].length() - 1);
    }
}
public class LeetCode2490 {
    public static void main(String[] args) {
        CircularSentence cs = new CircularSentence();

        // Test cases
        String sentence1 = "leetcode exercises sound delightful";
        String sentence2 = "eetcode";
        String sentence3 = "Leetcode is cool";

        System.out.println("Test case 1: " + cs.isCircularSentence(sentence1)); // Expected output: true
        System.out.println("Test case 2: " + cs.isCircularSentence(sentence2)); // Expected output: true
        System.out.println("Test case 3: " + cs.isCircularSentence(sentence3)); // Expected output: false

        // Additional test cases
        String sentence4 = "hello olleh";
        String sentence5 = "world";
        String sentence6 = "a b c d a";

        System.out.println("Test case 4: " + cs.isCircularSentence(sentence4)); // Expected output: true
        System.out.println("Test case 5: " + cs.isCircularSentence(sentence5)); // Expected output: true
        System.out.println("Test case 6: " + cs.isCircularSentence(sentence6)); // Expected output: true
    }
}
