package RegularPractice;
/* 2601. Prime Subtraction Operation
* You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.

Example 1:

Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.
Example 2:

Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.
Example 3:

Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
nums.length == n
* */

import java.util.*;

class PrimeSubtractionOperation {
    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = generatePrimes(1000);

        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= prev) {
                return false;
            }
            for (int j = primes.size() - 1; j >= 0; j--) {
                int prime = primes.get(j);
                if (prime < nums[i] && nums[i] - prime > prev) {
                    nums[i] -= prime;
                    break;
                }
            }
            prev = nums[i];
        }
        return true;
    }
    private List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
public class LeetCode2601 {
    public static void main(String[] args) {
        PrimeSubtractionOperation pr = new PrimeSubtractionOperation();
        System.out.println(pr.primeSubOperation(new int[]{2, 3, 5, 7, 11, 13}));
        System.out.println(pr.primeSubOperation(new int[]{5,8,3}));
        System.out.println(pr.primeSubOperation(new int[]{4,9,6,10}));
    }
}
