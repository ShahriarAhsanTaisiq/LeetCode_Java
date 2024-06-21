package RegularPractice;
/*69. Sqrt(x)

* Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
Constraints:
0 <= x <= 231 - 1
* */
class SquareRoot{
    public int mySqrt(int x){
        if(x<2) return x;
        int left=1, right=x/2, result =0;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(mid<=x/mid){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return  result;
    }
}
public class LeetCode69 {
    public static void main(String[] args) {
        SquareRoot solution = new SquareRoot();

        // Test cases
        int test1 = 4;
        int test2 = 8;
        int test3 = 0;
        int test4 = 1;
        int test5 = 15;
        int test6 = 16;
        int test7 = Integer.MAX_VALUE; // Edge case for very large number

        // Print results
        System.out.println("Test 1: " + solution.mySqrt(test1)); // Expected: 2
        System.out.println("Test 2: " + solution.mySqrt(test2)); // Expected: 2
        System.out.println("Test 3: " + solution.mySqrt(test3)); // Expected: 0
        System.out.println("Test 4: " + solution.mySqrt(test4)); // Expected: 1
        System.out.println("Test 5: " + solution.mySqrt(test5)); // Expected: 3
        System.out.println("Test 6: " + solution.mySqrt(test6)); // Expected: 4
        System.out.println("Test 7: " + solution.mySqrt(test7)); // Expected: 46340
    }
}
