package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

/**
 * @date: 07/03/2017 9:42 AM
 * @author: qinjiangbo@github.io
 * @description:
        Given an integer, convert it to a roman numeral.
        Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {

    /**
     * space-saving, but time-consuming
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Map<Integer, String> table = buildTable();
        StringBuffer stringBuffer = new StringBuffer();
        int radix = 1;
        while (num > 0) {
            int tail = num % 10;
            stringBuffer.insert(0, buildRoman(radix, tail, table));
            radix = radix * 10;
            num = num / 10;
        }
        return stringBuffer.toString();
    }

    /**
     * build the roman letter table
     * @return
     */
    private Map<Integer, String> buildTable() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        return map;
    }

    /**
     * build the roman letters
     * @param num
     * @param radix
     * @return
     */
    private String buildRoman(int radix, int num, Map<Integer, String> table) {
        StringBuffer stringBuffer = new StringBuffer();
        int r = num % 5; // remainder
        int x = num / 5; // division
        if ( r >= 0 && r <= 3) {
            if (x == 1) {
                stringBuffer.append(table.get(5 * radix));
            }
            for (int i = 0; i < r; i++) {
                stringBuffer.append(table.get(radix));
            }
        } else {
            stringBuffer.append(table.get(radix));
            stringBuffer.append(table.get(5 * (x + 1) * radix));
        }
        return stringBuffer.toString();
    }

    /**
     * another solutions, needed for extra spaces, time-saving
     * @param num
     * @return
     */
    public String intToRoman2(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

}
