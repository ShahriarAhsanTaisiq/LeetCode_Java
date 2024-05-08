package MayMonth;

import java.util.*;

/* 506. Relative Ranks
* You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.
Example 1:
Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:
Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
Constraints:
n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.
* */
class RelativeRanks{
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);
        String[] result = new String[score.length];

        int rank = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            int originalIndex = map.get(score[i]);
            if (rank == 1)
                result[originalIndex] = "Gold Medal";
            else if (rank == 2)
                result[originalIndex] = "Silver Medal";
            else if (rank == 3)
                result[originalIndex] = "Bronze Medal";
            else
                result[originalIndex] = String.valueOf(rank);
            rank++;
        }

        return result;
    }
}
public class Day8 {
    public static void main(String[] args) {
        RelativeRanks solution = new RelativeRanks();

        // Example 1
        int[] score1 = {5, 4, 3, 2, 1};
        String[] result1 = solution.findRelativeRanks(score1);
        System.out.println("Example 1:");
        printArray(result1);

        // Example 2
        int[] score2 = {10, 3, 8, 9, 4};
        String[] result2 = solution.findRelativeRanks(score2);
        System.out.println("\nExample 2:");
        printArray(result2);
    }

    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }
}
