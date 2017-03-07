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

        return 0;
    }

    /**
     * build the roman letter table
     * @return
     */
    private Map<String, Integer> buildTable() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map;
    }
}
