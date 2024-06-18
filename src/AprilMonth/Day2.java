package AprilMonth;
/*205. Isomorphic Strings
* Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
* */

class IsoMorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sToT = new int[256];
        int[] tToS = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT[sChar] != tToS[tChar]) {
                return false;
            }

            sToT[sChar] = i + 1;
            tToS[tChar] = i + 1;
        }

        return true;
    }
}
public class Day2 {
    public static void main(String[] args) {
        IsoMorphicString isoMorphicString = new IsoMorphicString();

        // Test case 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Test case 1: " + isoMorphicString.isIsomorphic(s1, t1)); // Expected output: true

        // Test case 2
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Test case 2: " + isoMorphicString.isIsomorphic(s2, t2)); // Expected output: false

        // Test case 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Test case 3: " + isoMorphicString.isIsomorphic(s3, t3)); // Expected output: true
    }
}
