package RegularPractice;

/*238. Product of Array Except Self
* Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
* */

class ProductOfArrayExceptSelf{
    public int [] productExceptSelf( int [] nums){
        int n = nums.length;
        int [] ans = new int[n];
        ans[0] = 1;
        // calculate prefix product
        for (int i = 1; i < n; i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int product = 1;
        for (int i = n-1; i>=0; i--){
            ans[i]*=product;
            product*=nums[i];
        }
        return ans;
    }
}
public class LeetCode238 {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Test case 1: " + arrayToString(nums1) + " => " + arrayToString(result1));

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Test case 2: " + arrayToString(nums2) + " => " + arrayToString(result2));

        // Add more test cases if needed
        int[] nums3 = {2, 3, 4, 5};
        int[] result3 = solution.productExceptSelf(nums3);
        System.out.println("Test case 3: " + arrayToString(nums3) + " => " + arrayToString(result3));

        int[] nums4 = {1, 2};
        int[] result4 = solution.productExceptSelf(nums4);
        System.out.println("Test case 4: " + arrayToString(nums4) + " => " + arrayToString(result4));
    }

    // Helper method to convert array to string
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
