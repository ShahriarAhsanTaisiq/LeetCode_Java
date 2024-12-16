package RegularPractice;
/* 3264. Final Array State After K Multiplication Operations I
* You are given an integer array nums, an integer k, and an integer multiplier.
You need to perform k operations on nums. In each operation:
Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.

Example 1:
Input: nums = [2,1,3,5,6], k = 5, multiplier = 2

Output: [8,4,6,5,6]

Explanation:

Operation	Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]
Example 2:
Input: nums = [1,2], k = 3, multiplier = 4

Output: [16,8]

Explanation:

Operation	Result
After operation 1	[4, 2]
After operation 2	[4, 8]
After operation 3	[16, 8]

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 10
1 <= multiplier <= 5
* */

class ArrayStateAfterKMultiplication{
    public int [] getFinalState(int [] nums, int k, int multiplier){
        int [] arr = new int[2];
        for( int i = 0; i < k; i++){
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }
        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int indx = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min){
                min = nums[i];
                indx = i;
            }
        }
        return new int[]{min, indx};
    }
}
public class LeetCode3264 {
    public static void main(String[] args) {
        ArrayStateAfterKMultiplication a = new ArrayStateAfterKMultiplication();

        // Test Case 1
        int[] nums1 = {2, 1, 3, 5, 6};
        int k1 = 5;
        int multiplier1 = 2;
        int[] result1 = a.getFinalState(nums1, k1, multiplier1);
        System.out.println("Final state for test case 1: " + java.util.Arrays.toString(result1));

        // Test Case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int multiplier2 = 4;
        int[] result2 = a.getFinalState(nums2, k2, multiplier2);
        System.out.println("Final state for test case 2: " + java.util.Arrays.toString(result2));
    }
}
