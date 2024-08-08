package RegularPractice;

/*274. H-Index
* Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:
Input: citations = [1,3,1]
Output: 1
Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
* */

import java.util.Arrays;

class HIndex{
    public int hIndex(int [] citations){
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++){
            if (citations[i] >= n-i){
                return n-i;
            }
        }
        return 0;
    }
}
public class LeetCode274 {
    public static void main(String[] args) {
        HIndex solution = new HIndex();

        // Test case 1
        int[] citations1 = {3, 0, 6, 1, 5};
        int result1 = solution.hIndex(citations1);
        System.out.println("Test case 1: " + Arrays.toString(citations1) + " => h-index: " + result1);

        // Test case 2
        int[] citations2 = {1, 3, 1};
        int result2 = solution.hIndex(citations2);
        System.out.println("Test case 2: " + Arrays.toString(citations2) + " => h-index: " + result2);

        // Add more test cases if needed
        // Example:
        int[] citations3 = {0, 1, 3, 5, 6};
        int result3 = solution.hIndex(citations3);
        System.out.println("Test case 3: " + Arrays.toString(citations3) + " => h-index: " + result3);

        int[] citations4 = {10, 8, 5, 4, 3};
        int result4 = solution.hIndex(citations4);
        System.out.println("Test case 4: " + Arrays.toString(citations4) + " => h-index: " + result4);

        int[] citations5 = {25, 8, 5, 3, 3};
        int result5 = solution.hIndex(citations5);
        System.out.println("Test case 5: " + Arrays.toString(citations5) + " => h-index: " + result5);
    }
}
