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
    public static ListNode genNodes(int... vals) {
        if (vals.length == 0) { return null; }
        if (vals.length == 1) { return new ListNode(vals[0]); }
        ListNode head = null, current = null; int len = vals.length;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                ListNode node = new ListNode(vals[i]);
                current.next = node;
                current = node;
            } else {
                current = new ListNode(vals[i]);
                head = current;
            }
        }
        return head;
    }

    /**
     * print all list nodes
     * @param head
     */
    public static void printNodes(ListNode head) {
        if (head == null) { return; }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(head.val + " -> ");
        while (head.next != null) {
            stringBuilder.append(head.next.val + " -> ");
            head = head.next;
        }
        String printStr = stringBuilder.toString();
        System.out.println(printStr.substring(0, printStr.lastIndexOf(" -> ")));
    }
}
