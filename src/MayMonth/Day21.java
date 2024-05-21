package MayMonth;
/*78. Subsets
* Given an integer array nums of unique elements, return all possible
subsets
 (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
* */
import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;
import java.util.List;

class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int subsetCount = 1 << n; // 2^n

        for (int i = 0; i < subsetCount; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}

public class Day21 {
    public static void main(String[] args) {
        Subset solution = new Subset();

        // Test case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: [1, 2, 3]");
        List<List<Integer>> result1 = solution.subsets(nums1);
        printResult(result1);

        // Test case 2
        int[] nums2 = {0};
        System.out.println("Input: [0]");
        List<List<Integer>> result2 = solution.subsets(nums2);
        printResult(result2);
    }

    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
