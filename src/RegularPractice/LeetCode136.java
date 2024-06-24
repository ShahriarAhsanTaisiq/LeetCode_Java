package RegularPractice;
/*136. Single Number
* Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
Constraints:
1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
* */
class SingleNumber{
    public int singleNumber(int []  nums){
        int result = 0;
        for(int i = 0; i<nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
public class LeetCode136 {
    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {2, 3, 2, 4, 4};
        int[] nums2 = {1, 1, 2, 2, 3};
        int[] nums3 = {7, 3, 5, 4, 5, 3, 4};

        SingleNumber solution = new SingleNumber();

        // Finding the single numbers
        int single1 = solution.singleNumber(nums1);
        int single2 = solution.singleNumber(nums2);
        int single3 = solution.singleNumber(nums3);

        // Printing the results
        System.out.println("The single number in nums1 is: " + single1); // Expected output: 3
        System.out.println("The single number in nums2 is: " + single2); // Expected output: 3
        System.out.println("The single number in nums3 is: " + single3); // Expected output: 7
    }
}
