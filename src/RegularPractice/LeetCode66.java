package RegularPractice;
/*66. Plus One
* You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
* Thus, the result should be [1,0].
Constraints:
1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
* */

class PlusOne{
    public int [] plusOne(int [] digits){
        for(int i = digits.length-1; i>=0; i--){
            if (digits[i]<9){
                digits[i]++;
                return  digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length+1];
        newDigits[0]= 1;
        return newDigits;
    }
}
public class LeetCode66 {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        // Test cases
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        printArray(result1);  // Expected output: [1, 2, 4]

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        printArray(result2);  // Expected output: [4, 3, 2, 2]

        int[] digits3 = {9, 9, 9};
        int[] result3 = solution.plusOne(digits3);
        printArray(result3);  // Expected output: [1, 0, 0, 0]

        int[] digits4 = {0};
        int[] result4 = solution.plusOne(digits4);
        printArray(result4);  // Expected output: [1]

        int[] digits5 = {8, 9, 9, 9};
        int[] result5 = solution.plusOne(digits5);
        printArray(result5);  // Expected output: [9, 0, 0, 0]
    }

    // Helper method to print arrays
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
