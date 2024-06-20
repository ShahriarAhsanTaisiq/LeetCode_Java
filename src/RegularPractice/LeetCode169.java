package RegularPractice;

import java.util.*;

/*169. Majority Element
* Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
Follow-up: Could you solve the problem in linear time and in O(1) space?
*
* */
class MajorityElements {
    public int majorityElement(int[] nums) {
        int element = 0, count = 0;
        for(int i =0; i< nums.length; i++){
            if(count == 0){
                element = nums[i];
            }
            if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
public class LeetCode169 {
    public static void main(String[] args) {
        MajorityElements majorityElements = new MajorityElements();

        // Test case 1: Majority element is 3
        int[] nums1 = {3, 2, 3};
        System.out.println("Test case 1: Input: "+Arrays.toString(nums1));
        System.out.println("Majority element: "+majorityElements.majorityElement(nums1)); // Output: 3

        // Test case 2: Majority element is 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test case 2: Input: "+Arrays.toString(nums2));
        System.out.println("Majority element: "+majorityElements.majorityElement(nums2)); // Output: 2

        // Test case 3: Majority element is 1
        int[] nums3 = {1};
        System.out.println("Test case 3: Input: "+Arrays.toString(nums3));
        System.out.println("Majority element: "+majorityElements.majorityElement(nums3)); // Output: 1
    }
}
