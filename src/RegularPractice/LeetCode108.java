package RegularPractice;

/*108. Convert Sorted Array to Binary Search Tree
* Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

* */

class TreeNode108{
    int val;
    TreeNode108 left, right;
    TreeNode108(int val){
        this.val = val;
        left = right = null;
    }
}

class ConvertSortedArrayToBST{
    public TreeNode108 sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode108 sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode108 node = new TreeNode108(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);

        return node;
    }
}
public class LeetCode108 {
    public static void main(String[] args) {
        ConvertSortedArrayToBST converter = new ConvertSortedArrayToBST();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode108 root1 = converter.sortedArrayToBST(nums1);
        System.out.println("Pre-order traversal of the BST for nums1:");
        preOrderTraversal(root1);
        System.out.println();

        int[] nums2 = {1, 3};
        TreeNode108 root2 = converter.sortedArrayToBST(nums2);
        System.out.println("Pre-order traversal of the BST for nums2:");
        preOrderTraversal(root2);
        System.out.println();
    }

    public static void preOrderTraversal(TreeNode108 node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}
