package AprilMonth;
/* 834. Sum of Distances in Tree
* There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
Example 1:
Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:
Input: n = 1, edges = []
Output: [0]
Example 3:
Input: n = 2, edges = [[1,0]]
Output: [1,1]
Constraints:
1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.
*
*/
import java.util.*;
class SumOfDistanceTree {
    private Map<Integer, List<Integer>> graph;
    private int[] count;
    private int[] res;

    private void dfs(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                res[node] += res[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                res[child] = res[node] - count[child] + (count.length - count[child]);
                dfs2(child, node);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new HashMap<>();
        count = new int[n];
        res = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return res;
    }
}
public class Day28 {
    public static void main(String[] args) {
        SumOfDistanceTree solution = new SumOfDistanceTree();
        // Test Case 1
        int n1 = 6;
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] result1 = solution.sumOfDistancesInTree(n1, edges1);
        System.out.println("Output for Test Case 1:");
        printArray(result1);

        // Test Case 2
        int n2 = 1;
        int[][] edges2 = {};
        int[] result2 = solution.sumOfDistancesInTree(n2, edges2);
        System.out.println("Output for Test Case 2:");
        printArray(result2);

        // Test Case 3
        int n3 = 2;
        int[][] edges3 = {{1, 0}};
        int[] result3 = solution.sumOfDistancesInTree(n3, edges3);
        System.out.println("Output for Test Case 3:");
        printArray(result3);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
