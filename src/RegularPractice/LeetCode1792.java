package RegularPractice;
/* 1792. Maximum Average Pass Ratio
* There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
Example 2:

Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485


Constraints:

1 <= classes.length <= 105
classes[i].length == 2
1 <= passi <= totali <= 105
1 <= extraStudents <= 105
* */

import java.util.PriorityQueue;

class MaxAvgPassRatio{
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] cls : classes) {
            double pass = cls[0], total = cls[1];
            double gain = calculateGains(pass, total);
            queue.offer(new double[] { gain, pass, total });
        }

        while (--extraStudents >= 0) {
            double[] curr = queue.poll();
            curr[1] += 1;
            curr[2] += 1;
            curr[0] = calculateGains(curr[1], curr[2]);
            queue.offer(curr);
        }

        double totalAvg = 0;
        while (!queue.isEmpty()) {
            double[] curr = queue.poll();
            totalAvg += curr[1] / curr[2];
        }

        return totalAvg / classes.length;
    }

    private double calculateGains(double pass, double total) {
        return (double) ((pass + 1) / (total + 1)) - (double) (pass / total);
    }
}
public class LeetCode1792 {
    public static void main(String[] args) {
        MaxAvgPassRatio maxAvgPassRatio = new MaxAvgPassRatio();
        // Test Case 1
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.printf("Test Case 1 Output: %.5f%n",
                maxAvgPassRatio.maxAverageRatio(classes1, extraStudents1)); // Expected: 0.78333

        // Test Case 2
        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents2 = 4;
        System.out.printf("Test Case 2 Output: %.5f%n",
                maxAvgPassRatio.maxAverageRatio(classes2, extraStudents2)); // Expected: 0.53485

        // Test Case 3: Edge Case - Single Class
        int[][] classes3 = {{3, 10}};
        int extraStudents3 = 5;
        System.out.printf("Test Case 3 Output: %.5f%n",
                maxAvgPassRatio.maxAverageRatio(classes3, extraStudents3)); // Custom Expected: Check edge logic

        // Test Case 4: All students already pass
        int[][] classes4 = {{10, 10}, {20, 20}};
        int extraStudents4 = 3;
        System.out.printf("Test Case 4 Output: %.5f%n",
                maxAvgPassRatio.maxAverageRatio(classes4, extraStudents4)); // Custom Expected: No real change
    }
}
