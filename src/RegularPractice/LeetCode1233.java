package RegularPractice;
/* 1233. Remove Sub-Folders from the Filesystem
*Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.

Example 1:

Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
Output: ["/a","/c/d","/c/f"]
Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
Example 2:

Input: folder = ["/a","/a/b/c","/a/b/d"]
Output: ["/a"]
Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
Example 3:

Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
Output: ["/a/b/c","/a/b/ca","/a/b/d"]

Constraints:
1 <= folder.length <= 4 * 104
2 <= folder[i].length <= 100
folder[i] contains only lowercase letters and '/'.
folder[i] always starts with the character '/'.
Each folder name is unique.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemoveSubFolders{
    public List<String> removeSubFolders(String [] folder){
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++){
            String lastFolder = ans.get(ans.size() - 1) + "/";
            if (!folder[i].startsWith(lastFolder)){
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
public class LeetCode1233 {
    public static void main(String[] args) {
        RemoveSubFolders removeSubFolders = new RemoveSubFolders();

        // Test case 1
        String[] folder1 = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> result1 = removeSubFolders.removeSubFolders(folder1);
        System.out.println("Output for folder1: " + result1);  // Expected: ["/a", "/c/d", "/c/f"]

        // Test case 2
        String[] folder2 = {"/a","/a/b/c","/a/b/d"};
        List<String> result2 = removeSubFolders.removeSubFolders(folder2);
        System.out.println("Output for folder2: " + result2);  // Expected: ["/a"]

        // Test case 3
        String[] folder3 = {"/a/b/c","/a/b/ca","/a/b/d"};
        List<String> result3 = removeSubFolders.removeSubFolders(folder3);
        System.out.println("Output for folder3: " + result3);  // Expected: ["/a/b/c", "/a/b/ca", "/a/b/d"]
    }
}
