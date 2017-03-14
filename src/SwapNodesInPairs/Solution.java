package SwapNodesInPairs;

import Commons.ListNode;
import Commons.Utils;

import java.util.List;

/**
 * @date: 14/03/2017 5:42 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a linked list, swap every two adjacent nodes and return its head.

        For example,
        Given 1->2->3->4, you should return the list as 2->1->4->3.

        Your algorithm should use only constant space. You may not modify the
        values in the list, only nodes itself can be changed.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {  return null; }
        ListNode pair1 = head, pair2 = head.next;
        return swap(pair1, pair2);
    }

    /**
     * use recursive way
     * @param pair1
     * @param pair2
     * @return
     */
    private ListNode swap(ListNode pair1, ListNode pair2) {
        // if the nodes' number is odd
        if (pair2 == null) {  return pair1; }
        ListNode newPair1 = pair2.next;
        // if next node is empty
        if (newPair1 == null) {
            pair2.next = pair1;
            pair1.next = null;
            return pair2;
        }
        ListNode newPair2 = newPair1.next;
        // swap pair1 & pair2
        pair2.next = pair1;
        pair1.next = swap(newPair1, newPair2);
        return pair2;
    }
}
