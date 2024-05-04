package MayMonth;

import java.util.Arrays;

/*881. Boats to Save People
* You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
Constraints:
1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
* */
class BoatToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }

        return boats;
    }
}
public class Day4 {
    public static void main(String[] args) {
        BoatToSavePeople solution = new BoatToSavePeople();

        // Test cases
        int[] people1 = {1, 2};
        int limit1 = 3;
        System.out.println("Example 1:");
        System.out.println("Input: people = " + Arrays.toString(people1) + ", limit = " + limit1);
        System.out.println("Output: " + solution.numRescueBoats(people1, limit1));

        int[] people2 = {3, 2, 2, 1};
        int limit2 = 3;
        System.out.println("\nExample 2:");
        System.out.println("Input: people = " + Arrays.toString(people2) + ", limit = " + limit2);
        System.out.println("Output: " + solution.numRescueBoats(people2, limit2));

        int[] people3 = {3, 5, 3, 4};
        int limit3 = 5;
        System.out.println("\nExample 3:");
        System.out.println("Input: people = " + Arrays.toString(people3) + ", limit = " + limit3);
        System.out.println("Output: " + solution.numRescueBoats(people3, limit3));
    }
}
