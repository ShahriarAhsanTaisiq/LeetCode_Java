package RegularPractice;

/*55. Jump Game
* You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
* */

class JumpGame{
    public boolean canJump(int [] nums){
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--){
            if( i +  nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}
public class LeetCode55 {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();

        int[] testCase1 = {2, 3, 1, 1, 4};
        int[] testCase2 = {3, 2, 1, 0, 4};

        System.out.println("Test Case 1: " + jumpGame.canJump(testCase1)); // Expected: true
        System.out.println("Test Case 2: " + jumpGame.canJump(testCase2)); // Expected: false
    }
}
