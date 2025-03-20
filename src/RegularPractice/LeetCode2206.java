package RegularPractice;
/* 2206. Divide Array Into Equal Pairs
* You are given an integer array nums consisting of 2 * n integers.
You need to divide nums into n pairs such that:
Each element belongs to exactly one pair.
The elements present in a pair are equal.
Return true if nums can be divided into n pairs, otherwise return false.

Example 1:

Input: nums = [3,2,3,2,2,2]
Output: true
Explanation:
There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
Example 2:

Input: nums = [1,2,3,4]
Output: false
Explanation:
There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.


Constraints:

nums.length == 2 * n
1 <= n <= 500
1 <= nums[i] <= 500

* */

import java.util.Arrays;

class DivideArrayIntoEqualPairs{
    public boolean divideArray(int [] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i+=2){
            if(nums[i] == nums[i-1]){
                return false;
            }
        }
        return true;
    }
}

public class LeetCode2206 {
    public static void main(String[] args) {
        DivideArrayIntoEqualPairs dp = new DivideArrayIntoEqualPairs();
        System.out.println(dp.divideArray(new int[]{3,2,3,2,2,2}));
        System.out.println(dp.divideArray(new int[]{1,2,3,4}));
        System.out.println(dp.divideArray(new int[]{10,9,12,3,5,8,7}));
        System.out.println(dp.divideArray(new int[]{1,2,3,4,5,6,7,8}));
    }
}
