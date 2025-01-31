package RegularPractice;

/* 374. Guess Number Higher or Lower
* We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1


Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
* */

class GuessGame {
    private final int pick;

    // Constructor to set the picked number (for testing)
    public GuessGame(int pick) {
        this.pick = pick;
    }

    // The predefined API (simulating behavior)
    private int guess(int num) {
        if (num > pick) return -1;
        if (num < pick) return 1;
        return 0;
    }
    public int guessNumber(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

public class LeetCode374 {
    public static void main(String[] args) {
        GuessGame game = new GuessGame(6);
        System.out.println(game.guessNumber(10));
        GuessGame game2 = new GuessGame(12);
        System.out.println(game2.guessNumber(20));

    }
}
