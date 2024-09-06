package RegularPractice;
/* 219. Contains Duplicate II
* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
* */

import java.util.HashMap;

class ContainsDuplicatesII{
    public boolean containsNearbyDuplicates( int [] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if (i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
public class LeetCode219 {
    public static void main(String[] args) {
        // Create an instance of the ContainsDuplicatesII class
        ContainsDuplicatesII solution = new ContainsDuplicatesII();

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println("Test case 1: " + solution.containsNearbyDuplicates(nums1, k1)); // Output: true

        // Test case 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println("Test case 2: " + solution.containsNearbyDuplicates(nums2, k2)); // Output: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println("Test case 3: " + solution.containsNearbyDuplicates(nums3, k3)); // Output: false
    }

}
