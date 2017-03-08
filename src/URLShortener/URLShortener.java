package URLShortener;

import java.util.HashMap;
import java.util.Map;

/**
 * @date: 08/03/2017 9:25 PM
 * @author: qinjiangbo@github.io
 */
public class URLShortener {

    private static final String DICT = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final char[] CHARS = DICT.toCharArray();
    private static final Map<Character, Integer> NUMBERS = new HashMap<>();

    static {
        int len = CHARS.length;
        for (int i = 0; i<len; i++) {
            NUMBERS.put(CHARS[i], i);
        }
    }

    /**
     * 根据从数据库中返回的记录ID生成对应的短网址编码
     * @param id (1-56.8billion)
     * @return
     */
    public static String encode(long id) {
        StringBuilder shortURL = new StringBuilder();
        while (id > 0) {
            int r = (int) (id % 62);
            shortURL.insert(0, CHARS[r]);
            id = id / 62;
        }
        int len = shortURL.length();
        while (len < 6) {
            shortURL.insert(0, CHARS[0]);
            len++;
        }
        return shortURL.toString();
    }

    /**
     * 根据获得的短网址编码解析出数据库中对应的记录ID
     * @param key 短网址 eg. RwTji8, GijT7Y等等
     * @return
     */
    public static long decode(String key) {
        char[] shorts = key.toCharArray();
        int len = shorts.length;
        long id = 0l;
        for (int i = 0; i < len; i++) {
            id = id + (long) (NUMBERS.get(shorts[i]) * Math.pow(62, len-i-1));
        }
        return id;
    }

    public static void main(String[] args) {
        System.out.println(encode(39729551080l));
        System.out.println(decode("RwTji8"));
    }
}
