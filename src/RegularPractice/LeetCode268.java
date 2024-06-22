package RegularPractice;

import java.util.Arrays;

/*268. Missing Number
* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
* */
class MissingNumber1{
    public int missingNums(int [] nums){
        // Approach 1
        Arrays.sort(nums);
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int sum = 0;
        for(int i =0; i<n; i++){
            sum+=nums[i];
        }
        return expectedSum-sum;

    }
}

class MissingNumber2{
    public int missingNums(int [] nums){
        // Approach 2
        int n = nums.length+1;
        int sum = n*(n+1)/2;
        for(int num: nums){
            num++;
            sum-=num;
        }
        return sum-1;
    }
}
public class LeetCode268 {
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {3, 0, 1},
                {0, 1},
                {9, 6, 4, 2, 3, 5, 7, 0, 1}
        };

        MissingNumber1 mn1 = new MissingNumber1();
        MissingNumber2 mn2 = new MissingNumber2();

        System.out.println("Testing MissingNumber1:");
        for (int[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Missing number: " + mn1.missingNums(testCase));
        }

        System.out.println("\nTesting MissingNumber2:");
        for (int[] testCase : testCases) {
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("Missing number: " + mn2.missingNums(testCase));
        }
    }

}
