package RegularPractice;
/*350. Intersection of Two Arrays II
* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once
* */

import java.util.Arrays;

class IntersectionOfTwoArrays{
    public int [] intersect(int [] num1, int [] num2){
        int [] count = new int[1001];
        int [] result = new int[Math.min(num1.length, num2.length)];
        for(int num:num1){
            count[num]++;
        }
        int resIndex = 0;
        for (int num: num2){
            if (count[num]>0){
                result[resIndex++] = num;
                count[num]--;
            }
        }
        return Arrays.copyOfRange(result,0,resIndex);
    }
}
public class LeetCode350 {
    public static void main(String [] args){
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

        // Test case 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result1 = solution.intersect(nums1, nums2);
        System.out.println("Test case 1 result: " + Arrays.toString(result1));  // Expected output: [2, 2]

        // Test case 2
        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] result2 = solution.intersect(nums1_2, nums2_2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2));  // Expected output: [4, 9] or [9, 4]
    }
}
