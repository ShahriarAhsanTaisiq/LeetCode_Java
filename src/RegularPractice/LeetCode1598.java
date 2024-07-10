package RegularPractice;
/*1598. Crawler Log Folder
* The Leetcode file system keeps a log each time some user performs a change folder operation.
The operations are described below:
"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
The file system starts in the main folder, then the operations in logs are performed.
Return the minimum number of operations needed to go back to the main folder after the change folder operations.

Example 1:

Input: logs = ["d1/","d2/","../","d21/","./"]
Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
Example 2:

Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
Output: 3
Example 3:

Input: logs = ["d1/","../","../","../"]
Output: 0

Constraints:
1 <= logs.length <= 103
2 <= logs[i].length <= 10
logs[i] contains lowercase English letters, digits, '.', and '/'.
logs[i] follows the format described in the statement.
Folder names consist of lowercase English letters and digits.
* */

class CrawlerLogFolder{
    public int minOperation(String [] logs){
        int step = 0;
        for (String log: logs){
            if (log.equals("../")){
                if (step > 0)
                    step--;
            } else if (!log.equals("./")){
                step++;
            }
        }
        return step;
    }
}
public class LeetCode1598 {
    public static void main(String[] args) {
        CrawlerLogFolder crawler = new CrawlerLogFolder();

        // Test case 1
        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(crawler.minOperation(logs1)); // Expected output: 2

        // Test case 2
        String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(crawler.minOperation(logs2)); // Expected output: 3

        // Test case 3
        String[] logs3 = {"d1/", "../", "../", "../"};
        System.out.println(crawler.minOperation(logs3)); // Expected output: 0

        // Additional Test case 4
        String[] logs4 = {"d1/", "d2/", "d3/", "../", "../", "../"};
        System.out.println(crawler.minOperation(logs4)); // Expected output: 0

        // Additional Test case 5
        String[] logs5 = {"./", "d1/", "../", "d2/", "d3/", "./"};
        System.out.println(crawler.minOperation(logs5)); // Expected output: 2
    }
}
