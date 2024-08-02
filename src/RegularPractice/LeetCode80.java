package RegularPractice;

/*80. Remove Duplicates from Sorted Array II
* Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
* */

class RemoveDuplicates2{
    public int removeDuplicatesII(int [] nums){
        if(nums.length <= 2){
            return nums.length;
        }
        // Two pointer approach
        int left = 2;
        for (int right = 2; right < nums.length; right++){
            if (nums[right] != nums[left - 2]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
public class LeetCode80 {
    public static void main(String[] args) {
        RemoveDuplicates2 solution = new RemoveDuplicates2();

        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = solution.removeDuplicatesII(nums1);
        System.out.println("Output: " + k1 + ", nums = " + arrayToString(nums1, k1));

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = solution.removeDuplicatesII(nums2);
        System.out.println("Output: " + k2 + ", nums = " + arrayToString(nums2, k2));
    }

    private static String arrayToString(int[] nums, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(nums[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
