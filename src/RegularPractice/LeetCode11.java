package RegularPractice;

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:
Input: height = [1,1]
Output: 1
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
* */

class ContainerWithMostWater{
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
public class LeetCode11 {
    public static void main(String[] args) {
        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater solution1 = new ContainerWithMostWater();
        int result1 = solution1.maxArea(height1);
        System.out.println("Maximum water that can be contained: " + result1); // Expected output: 49

        // Test case 2
        int[] height2 = {1, 1};
        ContainerWithMostWater solution2 = new ContainerWithMostWater();
        int result2 = solution2.maxArea(height2);
        System.out.println("Maximum water that can be contained: " + result2); // Expected output: 1

        // Additional test case
        int[] height3 = {4, 3, 2, 1, 4};
        ContainerWithMostWater solution3 = new ContainerWithMostWater();
        int result3 = solution3.maxArea(height3);
        System.out.println("Maximum water that can be contained: " + result3); // Expected output: 16

        // Another test case
        int[] height4 = {1, 2, 1};
        ContainerWithMostWater solution4 = new ContainerWithMostWater();
        int result4 = solution4.maxArea(height4);
        System.out.println("Maximum water that can be contained: " + result4); // Expected output: 2
    }
}
