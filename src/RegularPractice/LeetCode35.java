package RegularPractice;

/* 35. Search Insert Position
* Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
* */

class SearchInsetPosition{
    public int searchInsert( int [] nums, int target){
        int position = 0;
        for( int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
            if (target > nums[i]){
                position++;
            }
        }
        return position;
    }
}
public class LeetCode35 {
    public static void main(String[] args) {
        SearchInsetPosition searchInsertPosition = new SearchInsetPosition();

        // Test Case 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Expected: 2, Output: " + searchInsertPosition.searchInsert(nums1, target1));

        // Test Case 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Expected: 1, Output: " + searchInsertPosition.searchInsert(nums2, target2));

        // Test Case 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Expected: 4, Output: " + searchInsertPosition.searchInsert(nums3, target3));

        // Test Case 4
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Expected: 0, Output: " + searchInsertPosition.searchInsert(nums4, target4));

        // Test Case 5
        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("Expected: 0, Output: " + searchInsertPosition.searchInsert(nums5, target5));
    }
}
