package RegularPractice;

/* 3174. Clear Digits
* You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.

Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

Example 2:

Input: s = "cb34"

Output: ""

Explanation:

First, we apply the operation on s[2], and s becomes "c4".

Then we apply the operation on s[1], and s becomes "".

Constraints:

1 <= s.length <= 100
s consists only of lowercase English letters and digits.
The input is generated such that it is possible to delete all digits.

* */

class ClearDigits{
    public String clearDigits(String s){
        StringBuilder res = new StringBuilder();
        for(char ch: s.toCharArray()){
            if (Character.isDigit(ch)){
                if (res.length() > 0){
                    res.deleteCharAt(res.length() - 1);
                }
            } else{
                res.append(ch);
            }
        }
        return res.toString();
    }

}

public class LeetCode3174 {
    public static void main(String[] args) {
        ClearDigits c = new ClearDigits();
        System.out.println(c.clearDigits("abcd"));
        System.out.println(c.clearDigits("cb34"));
    }
}
