package RegularPractice.BinaryTree;

/*1530. Number of Good Leaf Nodes Pairs
* You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.
Return the number of good leaf node pairs in the tree.

Example 1:

Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
Example 2:

Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
Example 3:

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].

Constraints:

The number of nodes in the tree is in the range [1, 210].
1 <= Node.val <= 100
1 <= distance <= 10
* */
class TreeNode1530{
    int val;
    TreeNode1530 left,right;
    TreeNode1530(int val){
        this.val = val;
        left = right = null;
    }
}
class NumOfGoodLeaf{
    public int countPairs(TreeNode1530 root, int distance) {
        int[] result= new int[1];
        dfs(root,distance,result);
        return result[0];
    }
    private int[] dfs(TreeNode1530 node,int distance, int[] result){
        if(node==null){
            return new int[distance+1];
        }
        if(node.left==null&&node.right==null){
            int[] leafDistance = new int[distance+1];
            leafDistance[1]=1;
            return leafDistance;
        }

        int[] left=dfs(node.left,distance,result);
        int[] right= dfs(node.right,distance,result);

        //calculate result
        for(int i=1;i<=distance;i++){
            for(int j=1;j<=distance-i;j++){
                result[0] += left[i]*right[j];
            }
        }

        int[] leafDistance = new int[distance+1];
        for(int i=1;i<distance;i++){
            leafDistance[i+1]= left[i]+ right[i];
        }
        return leafDistance;
    }
}
public class LeetCpde1530 {
    public static void main(String[] args) {
        // Example 1
        TreeNode1530 root1 = new TreeNode1530(1);
        root1.left = new TreeNode1530(2);
        root1.right = new TreeNode1530(3);
        root1.left.right = new TreeNode1530(4);

        int distance1 = 3;
        NumOfGoodLeaf solver1 = new NumOfGoodLeaf();
        int result1 = solver1.countPairs(root1, distance1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        TreeNode1530 root2 = new TreeNode1530(1);
        root2.left = new TreeNode1530(2);
        root2.right = new TreeNode1530(3);
        root2.left.left = new TreeNode1530(4);
        root2.left.right = new TreeNode1530(5);
        root2.right.left = new TreeNode1530(6);
        root2.right.right = new TreeNode1530(7);

        int distance2 = 3;
        NumOfGoodLeaf solver2 = new NumOfGoodLeaf();
        int result2 = solver2.countPairs(root2, distance2);
        System.out.println("Example 2 Output: " + result2);

        // Example 3
        TreeNode1530 root3 = new TreeNode1530(7);
        root3.left = new TreeNode1530(1);
        root3.right = new TreeNode1530(4);
        root3.left.left = new TreeNode1530(6);
        root3.right.left = new TreeNode1530(5);
        root3.right.right = new TreeNode1530(3);
        root3.right.right.left = new TreeNode1530(2);

        int distance3 = 3;
        NumOfGoodLeaf solver3 = new NumOfGoodLeaf();
        int result3 = solver3.countPairs(root3, distance3);
        System.out.println("Example 3 Output: " + result3);
    }
}
