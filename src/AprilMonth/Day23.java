package AprilMonth;
/*
310. Minimum Height Trees
* A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
Example 1:
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
Constraints:
1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.*/


import java.util.*;

class HeightOfTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Initialize a queue with leaf nodes (nodes with only one neighbor)
        Deque<Integer> leaves = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Keep removing leaf nodes until we have 1 or 2 nodes left
        while (n > 2) {
            int numLeaves = leaves.size();
            n -= numLeaves;
            for (int i = 0; i < numLeaves; i++) {
                int leaf = leaves.poll();
                int neighbor = adjList.get(leaf).get(0);
                adjList.get(neighbor).remove(Integer.valueOf(leaf));
                if (adjList.get(neighbor).size() == 1) {
                    leaves.add(neighbor);
                }
            }
        }

        // The remaining nodes in the queue are the roots of MHTs
        result.addAll(leaves);
        return result;
    }
}
public class Day23 {
    public static void main(String[] args) {
        HeightOfTree solution = new HeightOfTree();

        // Example 1
        int n1 = 4;
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result1 = solution.findMinHeightTrees(n1, edges1);
        System.out.println("Minimum Height Trees for Example 1: " + result1);

        // Example 2
        int n2 = 6;
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> result2 = solution.findMinHeightTrees(n2, edges2);
        System.out.println("Minimum Height Trees for Example 2: " + result2);
    }
}
