package MayMonth;

import java.util.*;

/* 1442. Count Triplets That Can Form Two Arrays of Equal XOR
* Given an array of integers arr.
We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
Let's define a and b as follows:
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.
Return the number of triplets (i, j and k) Where a == b.
Example 1:
Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
Example 2:
Input: arr = [1,1,1,1,1]
Output: 10
Constraints:
1 <= arr.length <= 300
1 <= arr[i] <= 108
* */
class TripletsCount {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        int[] prefixXOR = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> sum = new HashMap<>();

        for (int k = 0; k < n; k++) {
            if (frequency.containsKey(prefixXOR[k + 1])) {
                count += frequency.get(prefixXOR[k + 1]) * k - sum.get(prefixXOR[k + 1]);
            }

            frequency.put(prefixXOR[k], frequency.getOrDefault(prefixXOR[k], 0) + 1);
            sum.put(prefixXOR[k], sum.getOrDefault(prefixXOR[k], 0) + k);
        }

        return count;
    }
}
public class Day30 {
    public static void main(String[] args) {
        TripletsCount solution = new TripletsCount();

        // Test case 1
        int[] arr1 = {2, 3, 1, 6, 7};
        System.out.println("Test Case 1: " + solution.countTriplets(arr1));  // Expected output: 4

        // Test case 2
        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("Test Case 2: " + solution.countTriplets(arr2));  // Expected output: 10

        // Additional test cases
        int[] arr3 = {1, 3, 5, 7, 9};
        System.out.println("Test Case 3: " + solution.countTriplets(arr3));  // Expected output: 3
    }

}
