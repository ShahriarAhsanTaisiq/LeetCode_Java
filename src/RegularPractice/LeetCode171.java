package RegularPractice;
/*171. Excel Sheet Column Number
* Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
Example 1:
Input: columnTitle = "A"
Output: 1
Example 2:
Input: columnTitle = "AB"
Output: 28
Example 3:
Input: columnTitle = "ZY"
Output: 701

Constraints:
1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
* */

class ExcelSheetColNum{
    public int titleToNumber(String s){
        if(s == null || s.isEmpty()){
            return -1;
        }
        int sum = 0;
        for (char c: s.toUpperCase().toCharArray()){
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
public class LeetCode171 {
    public static void main(String[] args) {
        ExcelSheetColNum converter = new ExcelSheetColNum();
        System.out.println(converter.titleToNumber("A"));   // Output: 1
        System.out.println(converter.titleToNumber("AB"));  // Output: 28
        System.out.println(converter.titleToNumber("ZY"));  // Output: 701
    }
}
