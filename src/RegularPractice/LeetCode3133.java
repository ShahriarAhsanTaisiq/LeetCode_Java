package RegularPractice;
/* 3133. Minimum Array End
* You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x.
Return the minimum possible value of nums[n - 1].

Example 1:

Input: n = 3, x = 4

Output: 6

Explanation:

nums can be [4,5,6] and its last element is 6.

Example 2:

Input: n = 2, x = 7

Output: 15

Explanation:
nums can be [7,15] and its last element is 15.

Constraints:

1 <= n, x <= 108
* */

class MinimumArrayEnd{
    public long minEnd(int n, int x){
        long result = x;
        while (--n > 0){
            result = (result + 1) | x;
        }
        return result;
    }
}
public class LeetCode3133 {
    public static void main(String[] args) {
        MinimumArrayEnd obj = new MinimumArrayEnd();
        System.out.println(obj.minEnd(3, 4));
        System.out.println(obj.minEnd(5, 3));
        System.out.println(obj.minEnd(3, 5));
        System.out.println(obj.minEnd(5, 5));
        System.out.println(obj.minEnd(2, 7));
    }
}
