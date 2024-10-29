package RegularPractice;
/* 278. First Bad Version
* You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:
Input: n = 1, bad = 1
Output: 1
Constraints:
1 <= bad <= n <= 231 - 1
* */

class FirstBadVersion {
    private final int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        int startVersion = 1;
        int endVersion = n;
        int badVersion = -1;

        while (startVersion <= endVersion) {
            int mid = startVersion + (endVersion - startVersion) / 2;
            if (isBadVersion(mid)) {
                badVersion = mid;
                endVersion = mid - 1;
            } else {
                startVersion = mid + 1;
            }
        }

        return badVersion;
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

public class LeetCode278 {
    public static void main(String[] args) {
        int n = 5;
        int bad = 4;

        FirstBadVersion solution = new FirstBadVersion(bad);
        int firstBad = solution.firstBadVersion(n);

        System.out.println("First Bad Version: " + firstBad); // Expected output: 4
    }
}
