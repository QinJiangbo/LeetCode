package RemoveNodeFromList;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 09/03/2017 1:54 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a linked list, remove the nth node from the end of list
        and return its head.

        For example,
            Given linked list: 1->2->3->4->5, and n = 2.
            After removing the second node from the end, the linked list
            becomes 1->2->3->5.

        Note:
            Given n will always be valid.
            Try to do this in one pass.
 */
public class Solution {

    /**
     * ACCEPT version, with extra space
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode current = head;
        nodes.add(current);
        while (current.next != null) {
            current = current.next;
            nodes.add(current);
        }
        int len = nodes.size();
        nodes.remove(len - n);
        len = len -1;
        if (len > 1) {
            for (int i = 0; i < len-1; i++) {
                nodes.get(i).next = nodes.get(i+1);
            }
            nodes.get(len-1).next = null;
        } else {
            if (nodes.size() != 0) {
                nodes.get(0).next = null;
            }
        }
        return nodes.size() == 0 ? null : nodes.get(0);
    }
}
