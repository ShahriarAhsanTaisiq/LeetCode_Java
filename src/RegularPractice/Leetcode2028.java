package RegularPractice;

/*2028. Find Missing Observations
* You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.
You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.
Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
The average value of a set of k numbers is the sum of the numbers divided by k.
Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.


Example 1:

Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
Example 2:

Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
Example 3:

Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.


Constraints:

m == rolls.length
1 <= n, m <= 105
1 <= rolls[i], mean <= 6
* */

import java.util.Arrays;

class MissingObservation{
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        // missing
        int missing = mean * (n + rolls.length) - sum;
        if (missing < n || missing > 6 * n) {
            return new int[0];
        }

        int part = missing / n, rem = missing % n;
        int[] arr = new int[n];
        Arrays.fill(arr, part);
        for (int i = 0; i < rem; i++) {
            arr[i]++;
        }
        return arr;
    }
}
public class Leetcode2028 {
    public static void main(String[] args) {
        // Create an instance of MissingObservation
        MissingObservation missingObservation = new MissingObservation();

        // Test case 1
        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4;
        int n1 = 2;
        int[] result1 = missingObservation.missingRolls(rolls1, mean1, n1);
        System.out.println("Test Case 1: " + Arrays.toString(result1));  // Expected Output: [6, 6]

        // Test case 2
        int[] rolls2 = {1, 5, 6};
        int mean2 = 3;
        int n2 = 4;
        int[] result2 = missingObservation.missingRolls(rolls2, mean2, n2);
        System.out.println("Test Case 2: " + Arrays.toString(result2));  // Expected Output: [2, 3, 2, 2]

        // Test case 3
        int[] rolls3 = {1, 2, 3, 4};
        int mean3 = 6;
        int n3 = 4;
        int[] result3 = missingObservation.missingRolls(rolls3, mean3, n3);
        System.out.println("Test Case 3: " + Arrays.toString(result3));  // Expected Output: []

        // Add more test cases as needed
    }
}
