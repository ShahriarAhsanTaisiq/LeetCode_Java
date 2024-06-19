package RegularPractice;
/*605. Can Place Flowers
*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
* */

class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        for(int i=0; i<flowerbed.length; i+=2){
            if(i+1<flowerbed.length && flowerbed[i+1]==1){
                i++;
            }
            else if(flowerbed[i]==0){
                n--;
                if(n<=0){
                    return true;
                }
            }
        }
        return false;
    }
}public class LeetCode605 {
    public static void main(String[] args) {
        PlaceFlowers solution = new PlaceFlowers();

        // Test cases
        int[][] flowerbeds = {
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        int[] nValues = {2, 2, 1, 3, 0};

        // Expected results: true, true, true, true, true
        for (int i = 0; i < flowerbeds.length; i++) {
            int[] flowerbed = flowerbeds[i];
            int n = nValues[i];
            boolean result = solution.canPlaceFlowers(flowerbed, n);
            System.out.println("Test case " + (i + 1) + ": " + result);
        }
    }
}
