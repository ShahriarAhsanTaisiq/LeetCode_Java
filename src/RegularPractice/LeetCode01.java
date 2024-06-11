package RegularPractice;

import java.util.HashMap;

/*1. Two Sum
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
* */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // for (int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]+ nums[j]==target && i!=j){return new int[]{i,j};}
        //     }
        // }
        // return null;
        int [] result = new int [2];
        HashMap<Integer,Integer> data = new HashMap <>();

        for(int i=0; i<nums.length; i++){
            if(data.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = data.get(target-nums[i]);
                break;
            }
            data.put(nums[i],i);
        }
        return result;
    }
}
public class LeetCode01 {
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Indices: " + result1[0] + ", " + result1[1]);

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Indices: " + result2[0] + ", " + result2[1]);

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Indices: " + result3[0] + ", " + result3[1]);
    }
}
