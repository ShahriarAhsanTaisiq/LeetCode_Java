package RegularPractice;

/*135. Candy
* There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.

Constraints:
n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
* */

import java.util.Arrays;

class Candies{
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candies = new  int [n];

//        for(int i = 0; i < n; i++){
//            candies[i] = 1;
//        }
        //Both are same
        Arrays.fill(candies, 1);

        for( int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for( int i = n - 2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        int total = 0;
        for(int candy: candies){
            total += candy;
        }
        return total;
    }
}
public class LeetCode135 {
    public static void main(String[] args) {
        // Create an instance of the Candies class
        Candies candiesSolver = new Candies();

        // Test case 1
        int[] ratings1 = {1, 0, 2};
        int result1 = candiesSolver.candy(ratings1);
        System.out.println("Test Case 1:");
        System.out.println("Ratings: [1, 0, 2]");
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + result1);
        System.out.println();

        // Test case 2
        int[] ratings2 = {1, 2, 2};
        int result2 = candiesSolver.candy(ratings2);
        System.out.println("Test Case 2:");
        System.out.println("Ratings: [1, 2, 2]");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + result2);
        System.out.println();

        // Additional test case
        int[] ratings3 = {1, 3, 2, 2, 1};
        int result3 = candiesSolver.candy(ratings3);
        System.out.println("Test Case 3:");
        System.out.println("Ratings: [1, 3, 2, 2, 1]");
        System.out.println("Expected Output: 7");
        System.out.println("Actual Output: " + result3);
    }
}
