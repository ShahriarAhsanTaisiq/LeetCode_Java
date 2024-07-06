package RegularPractice;

/*2582. Pass the Pillow

* There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.
For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.

Example 1:

Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
After five seconds, the 2nd person is holding the pillow.
Example 2:

Input: n = 3, time = 2
Output: 3
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3.
After two seconds, the 3rd person is holding the pillow.

Constraints:

2 <= n <= 1000
1 <= time <= 1000
* */
class PassThePillow{
    public int passThePillow (int n, int time){
        int totalCycle = 2 * (n-1);
        int position = time % totalCycle;
        if (position < n){
            return position + 1;
        }
        return 2 * n - position -1;
    }
}
public class LeetCode2582 {
    public static void main(String[] args) {
        PassThePillow solution = new PassThePillow();

        // Test cases
        int[][] testCases = {
                {4, 5}, // Expected output: 2
                {3, 2}, // Expected output: 3
                {5, 10}, // Expected output: 1
                {6, 7}, // Expected output: 5
                {7, 14}, // Expected output: 1
        };

        // Running the test cases
        for (int[] testCase : testCases) {
            int n = testCase[0];
            int time = testCase[1];
            int result = solution.passThePillow(n, time);
            System.out.printf("passThePillow(%d, %d) = %d%n", n, time, result);
        }
    }

}
