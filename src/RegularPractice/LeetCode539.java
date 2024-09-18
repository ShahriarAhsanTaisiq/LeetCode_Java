package RegularPractice;
/*539. Minimum Time Difference
* Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

* Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1
*
Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0
*
Constraints:
2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".
* */

import java.util.*;
class MinTimeDiff{
    public int findMinDifference( List<String> timePoints){
        int [] minutes =  new int [timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++){
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0,2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }
        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++){
            ans = Math.min(ans, minutes[i+1] - minutes[i]);
        }
        return Math.min( ans, 24*60 - minutes[minutes.length -1 ] + minutes[0]);
    }
}
public class LeetCode539 {
    public static void main(String[] args) {
        MinTimeDiff minTimeDiff = new MinTimeDiff();
        // Test case 1
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        int result1 = minTimeDiff.findMinDifference(timePoints1);
        System.out.println("Minimum difference for timePoints1: " + result1); // Expected output: 1
        // Test case 2
        List<String> timePoints2 = Arrays.asList("00:00", "23:59", "00:00");
        int result2 = minTimeDiff.findMinDifference(timePoints2);
        System.out.println("Minimum difference for timePoints2: " + result2); // Expected output: 0
    }
}
