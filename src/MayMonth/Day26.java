package MayMonth;
/*552. Student Attendance Record II
* An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:
The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
Example 1:
Input: n = 2
Output: 8
Explanation: There are 8 records with length 2 that are eligible for an award:
"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
Example 2:
Input: n = 1
Output: 3
Example 3:
Input: n = 10101
Output: 183236316
Constraints:
1 <= n <= 105
* */
class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3];

        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Ending with P
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;
                }
            }

            // Ending with A
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % MOD;
            }

            // Ending with L
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % MOD;
                }
            }
        }

        int result = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                result = (result + dp[n][j][k]) % MOD;
            }
        }

        return result;
    }
}

public class Day26 {
    public static void main(String[] args) {
        StudentAttendanceRecordII solution = new StudentAttendanceRecordII();

        // Test cases
        int n1 = 2;
        int n2 = 1;
        int n3 = 10101;

        // Expected outputs: 8, 3, 183236316 (for example 3, the exact output might vary and should be validated)

        System.out.println("Number of valid attendance records of length " + n1 + ": " + solution.checkRecord(n1));
        System.out.println("Number of valid attendance records of length " + n2 + ": " + solution.checkRecord(n2));
        System.out.println("Number of valid attendance records of length " + n3 + ": " + solution.checkRecord(n3));
    }
}
