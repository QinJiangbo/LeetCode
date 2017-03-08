package ZigZagConversion;

/**
 * @date: 05/03/2017 4:03 PM
 * @author: qinjiangbo@github.io
 * @description:
        The string "PAYPALISHIRING" is written in a zigzag pattern
        on a given number of rows like this: (you may want to display
        this pattern in a fixed font for better legibility)
            P   A   H   N
            A P L S I I G
            Y   I   R
        And then read line by line: "PAHNAPLSIIGYIR"
        Write the code that will take a string and make this conversion given a number of rows:

        string convert(string text, int nRows);
        convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {


    /**
     * take a simple example
     *
     *    i ->  0     6      12      18
     *          1   5 7   11 13   17 19
     *          2 4   8 10   14 16   20
     *          3     9      15      21
     * from above we can find 4 columns, they can be expressed like
     * [i + 6 * k (k = 0, 1, 2, 3...)], 6 is a fixed value (2 * n - 2)
     * and as for items in the gaps, they can be expressed like
     * [6 * k - i (k = 1, 2, 3...)], so we can get the following code
     *
     */
    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() < 3 || s.length() <= numRows) return s;
        int fixValue = numRows * 2 - 2;
        int len = s.length();
        StringBuilder zigzag = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int k = 1;
            for (int j = i; j < len; j = j + fixValue) {
                zigzag.append(s.charAt(j));
                if (i != 0 && i != numRows -1 && fixValue * k - i < len) {
                    zigzag.append(s.charAt(fixValue * k - i));
                    k++;
                }
            }
        }
        return zigzag.toString();
    }

    /**
     * Time Limit Exceeded solution
     * gap between two periods is (n-2), num of letter in one period is (n + n - 2)
     * width of each period is (1 + n - 2)
     * the number of period is [len(s) / (2n-2)]
     * the column number is (n-1) * [len(s)/(2n-2)]) or (n-1) * [len(s)/(2n-2) + 1])
     * so the array is (n * [(len(s) / (2n - 2)) * (n - 1)]) scale, which is
     * (n * len(s) / 2)
     * @param s
     * @param numRows
     * @return
     */
    @Deprecated
    public String convert0(String s, int numRows) {
        if(numRows <= 1 || s.length() < 3 || s.length() <= numRows) return s;
        int fixValue = numRows * 2 - 2;
        int len = s.length();
        String zigzag = "";
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int k = 0;
                while ((fixValue * k + i) < len) {
                    zigzag = zigzag + s.charAt(fixValue * k + i);
                    k++;
                }
            } else {
                int k = 0;
                while ((fixValue * k + i < len) || (fixValue * k - i < len)) {
                    if (k == 0) {
                        zigzag = zigzag + s.charAt(i);
                    } else {
                        if (fixValue * k - i < len) {
                            zigzag = zigzag + s.charAt(fixValue * k - i);
                        }
                        if (fixValue * k + i < len) {
                            zigzag = zigzag + s.charAt(fixValue * k + i);
                        }
                    }
                    k++;
                }
            }
        }
        return zigzag;
    }
}
