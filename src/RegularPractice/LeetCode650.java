package RegularPractice;
/* 650. 2 Keys Keyboard
* There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
Example 1:
Input: n = 3
Output: 3
Explanation: Initially, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Example 2:
Input: n = 1
Output: 0
Constraints:
1 <= n <= 1000
* */
class KeysKeyboard{
    public int minStep(int n){
        if (n == 1){
            return 0;
        }
        int steps = 0;
        for(int i = 2; i * i <= n; i++){
            while( n % i == 0){
                steps += i;
                n /= i;
            }
        }
        if ( n > 1){
            steps += n;
        }
        return steps;
    }
}
public class LeetCode650 {
    public static void main(String[] args) {
        KeysKeyboard keyboard = new KeysKeyboard();

        int n1 = 3;
        System.out.println("Minimum steps to get " + n1 + " 'A's: " + keyboard.minStep(n1)); // Output: 3

        int n2 = 1;
        System.out.println("Minimum steps to get " + n2 + " 'A's: " + keyboard.minStep(n2)); // Output: 0

        int n3 = 6;
        System.out.println("Minimum steps to get " + n3 + " 'A's: " + keyboard.minStep(n3)); // Output: 5

        int n4 = 9;
        System.out.println("Minimum steps to get " + n4 + " 'A's: " + keyboard.minStep(n4)); // Output: 6
    }
}
