package RegularPractice;

import java.util.HashSet;

/*217. Contains Duplicate
* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Example 1:
Input: nums = [1,2,3,1]
Output: true
Example 2:
Input: nums = [1,2,3,4]
Output: false
Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
* */
class ContainsDuplicate{
    public boolean containsDuplicate(int[] nums) {
        // Brute force approach
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i]==nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        HashSet<Integer> res = new HashSet<>();
        for(int num: nums){
            if(res.contains(num)){
                return true;
            }
            res.add(num);
        }
        return false;
    }
}
public class LeetCode217 {
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test cases
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {1, 2, 3, 4, 5, 2};
        int[] test3 = {1, 1, 1, 1, 1};
        int[] test4 = {};
        int[] test5 = {1};

        System.out.println("Test case 1: " + solution.containsDuplicate(test1)); // Expected: false
        System.out.println("Test case 2: " + solution.containsDuplicate(test2)); // Expected: true
        System.out.println("Test case 3: " + solution.containsDuplicate(test3)); // Expected: true
        System.out.println("Test case 4: " + solution.containsDuplicate(test4)); // Expected: false
        System.out.println("Test case 5: " + solution.containsDuplicate(test5)); // Expected: false
    }
}
