package RegularPractice;
import java.util.*;
/*27. Remove Element
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.
int k = removeElement(nums, val); // Calls your implementation
assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
* */
class RemoveElements{
    int removeElement(int [] nums, int val){
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] != val){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
public class LeetCode27 {
    public static void main(String[] args) {
        RemoveElements solution = new RemoveElements();
        // Test case 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        int[] expectedNums1 = {2, 2}; // Expected result after sorting the first k elements
        Arrays.sort(nums1, 0, k1); // Sort first k elements of nums1
        assert k1 == expectedNums1.length : "Test case 1 failed";
        for (int i = 0; i < k1; i++) {
            assert nums1[i] == expectedNums1[i] : "Test case 1 failed at index " + i;
        }
        System.out.println("Test case 1 passed");
        // Test case 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        int[] expectedNums2 = {0, 1, 0, 3, 4}; // Expected result after sorting the first k elements
        Arrays.sort(nums2, 0, k2); // Sort first k elements of nums2
        assert k2 == expectedNums2.length : "Test case 2 failed";
        for (int i = 0; i < k2; i++) {
            assert nums2[i] == expectedNums2[i] : "Test case 2 failed at index " + i;
        }
        System.out.println("Test case 2 passed");
    }
}
