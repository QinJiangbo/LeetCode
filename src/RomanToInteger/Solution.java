package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @date: 07/03/2017 2:26 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a roman numeral, convert it to an integer.
        Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {

    public int romanToInt(String s) {
        int len = s.length(), number = 0;
        Map<Character, Integer> table = buildTable();
        for (int i = 0; i < len; i++) {
            number = number + table.get(s.charAt(i));
        }
        if (s.contains("CM") || s.contains("CD")) { number = number - 200; }
        if (s.contains("XC") || s.contains("XL")) { number = number - 20; }
        if (s.contains("IX") || s.contains("IV")) { number = number - 2; }
        return number;
    }

    /**
     * build the roman letter table
     * @return
     */
    private Map<Character, Integer> buildTable() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
