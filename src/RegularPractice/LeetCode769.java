package RegularPractice;
/* 769. Max Chunks To Make Sorted
* You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Example 1:
Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
*
Example 2:
Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

Constraints:
n == arr.length
1 <= n <= 10
0 <= arr[i] < n
All the elements of arr are unique.
* */
class MaxChunksToSorted{
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if (max == i){
                count++;
            }
        }
        return count;
    }
}
public class LeetCode769 {
    public static void main(String[] args) {
        MaxChunksToSorted maxChunksToSorted = new MaxChunksToSorted();
        int[] arr = {1,2,3,4,5};
        System.out.println(maxChunksToSorted.maxChunksToSorted(arr));
        int[] arr1 = {4,3,2,1,0};
        System.out.println(maxChunksToSorted.maxChunksToSorted(arr1));
        int[] arr2 = {1,0,2,3,4};
        System.out.println(maxChunksToSorted.maxChunksToSorted(arr2));
        int [] arr3 = {4,6,3,7,0,1};
        System.out.println(maxChunksToSorted.maxChunksToSorted(arr3));
        int [] arr4 = {11,12,13,14,15};
        System.out.println(maxChunksToSorted.maxChunksToSorted(arr4));
    }
}
