package Interview;

/**
 * @date: 26/04/2017 8:10 PM
 * @author: qinjiangbo@github.io
 */
public class PatternMatcher {

    public static void main(String[] args) {
        String text1 = "100-trade-done";
        String text2 = "200-trade-done";
        String text3 = "200-paid-done";
        String pattern = "*trade-done";
        System.out.println(filter(text1, pattern));
        System.out.println(filter(text2, pattern));
        System.out.println(filter(text3, pattern));

    }

    private static boolean filter(String text, String pattern) {
        if (text.length() < pattern.length()) { return false; }
        int j = 0; boolean flag = true;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '?') {
                j++;
            } else if (pattern.charAt(i) == '*') {
                while (text.charAt(j) != pattern.charAt(i+1)) {
                    j++;
                    if (j == text.length()) { flag = false; return flag; }
                }
            } else {
                if (pattern.charAt(i) == text.charAt(j)) { j++; }
                else {  flag = false; break; }
            }
        }
        return flag;
    }
}
