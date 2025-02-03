package RegularPractice;
/* 1752. Check if Array Is Sorted and Rotated
* Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

* */

class SortedAndRotatedArray {
    public boolean check(int [] nums){
        int n = nums.length;
        int count = 0;
        if (nums[0] < nums[n - 1])
            count++;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1])
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
public class LeetCode1752 {
    public static void main(String[] args) {
        SortedAndRotatedArray sortedAndRotatedArray = new SortedAndRotatedArray();
        System.out.println(sortedAndRotatedArray.check(new int[]{3,4,5,1,2}));
        System.out.println(sortedAndRotatedArray.check(new int[]{2,1,4,5,6,7}));
        System.out.println(sortedAndRotatedArray.check(new int[]{1,2,3,4,5,6,7}));
    }
}
