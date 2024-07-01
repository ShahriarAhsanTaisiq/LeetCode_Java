package RegularPractice;
/*1550. Three Consecutive Odds
* Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

Example 1:
Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:
Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds

Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 1000
* */
class ThreeConsecutiveOdds{
    public boolean threeConsecutiveOdds(int [] arr){
        for (int i=0; i<arr.length-2; i++){
            if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}
public class LeetCode1550 {
    public static void main(String [] args){
        ThreeConsecutiveOdds solution = new ThreeConsecutiveOdds();

        // Test cases
        int[] arr1 = {2, 6, 4, 1};
        int[] arr2 = {1, 3, 5, 7};
        int[] arr3 = {2, 6, 4, 1, 3, 5};
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] arr5 = {1, 1, 1};

        System.out.println(solution.threeConsecutiveOdds(arr1)); // Output: false
        System.out.println(solution.threeConsecutiveOdds(arr2)); // Output: true
        System.out.println(solution.threeConsecutiveOdds(arr3)); // Output: true
        System.out.println(solution.threeConsecutiveOdds(arr4)); // Output: false
        System.out.println(solution.threeConsecutiveOdds(arr5)); // Output: true
    }
}
