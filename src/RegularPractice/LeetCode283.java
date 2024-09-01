package RegularPractice;

/*283. Move Zeroes
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]
Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
Follow up: Could you minimize the total number of operations done?
* */

import java.util.Arrays;

class MoveZeroes{
    public void moveZeroes(int [] nums){
        int a = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[a] = nums[i];
                a++;
            }
        }
        for (int i = a; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
public class LeetCode283 {
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();

        // Test case 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Original array: " + Arrays.toString(nums1));
        mz.moveZeroes(nums1);
        System.out.println("After moving zeroes: " + Arrays.toString(nums1));

        // Test case 2
        int[] nums2 = {0};
        System.out.println("Original array: " + Arrays.toString(nums2));
        mz.moveZeroes(nums2);
        System.out.println("After moving zeroes: " + Arrays.toString(nums2));

    }
}
