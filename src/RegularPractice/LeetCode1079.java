package RegularPractice;

/* 1079. Letter Tile Possibilities
* You have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.

* */

class LetterTilePossibilities{
    public int numTilePossibilities(String tiles) {
        int [] freq = new int[26];
        for (char ch:tiles.toCharArray()){
            freq[ch - 'A']++;
        }
        return helper(freq);
    }

    private int helper(int[] freq) {
        int count = 0;
        for( int i = 0; i < 26; i++){
            if(freq[i] > 0){
                count++;
                freq[i]--;
                count += helper(freq);
                freq[i]++;
            }
        }
        return count;
    }
}

public class LeetCode1079 {
    public static void main(String[] args) {
        LetterTilePossibilities obj = new LetterTilePossibilities();
        System.out.println(obj.numTilePossibilities("AAB"));
        System.out.println(obj.numTilePossibilities("AAABBC"));
        System.out.println(obj.numTilePossibilities("V"));
    }
}
