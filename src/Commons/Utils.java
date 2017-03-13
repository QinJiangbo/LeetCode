package Commons;

/**
 * @date: 13/03/2017 10:06 PM
 * @author: qinjiangbo@github.io
 */
public class Utils {

    /**
     * generate list nodes for test cases
     * @param vals
     * @return
     */
    public ListNode genNodes(int... vals) {
        if (vals.length == 0) { return null; }
        ListNode head = new ListNode(vals[0]), current;
        int len = vals.length;
        for (int i = 0; i < len; i++) {

        }
        return head;
    }

    /**
     * print all list nodes
     * @param head
     */
    public void printNodes(ListNode head) {

    }
}
