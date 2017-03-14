package ReverseNodesInKGroup;

import Commons.ListNode;

/**
 * @date: 14/03/2017 7:54 PM
 * @author: qinjiangbo@github.io
 * @description:
        Given a linked list, reverse the nodes of a linked list k at a time
        and return its modified list. k is a positive integer and is less than
        or equal to the length of the linked list. If the number of nodes is
        not a multiple of k then left-out nodes in the end should remain as it is.

        You may not alter the values in the nodes, only nodes itself may be changed.
        Only constant memory is allowed.

        For example,
            Given this linked list: 1->2->3->4->5
            For k = 2, you should return: 2->1->4->3->5
            For k = 3, you should return: 3->2->1->4->5
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null && count != k) {
            current = current.next;
            count++;
        }
        // k+1 node has been found
        if (count == k) {
            current = reverseKGroup(current, k);
            while (count-- > 0) {
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = current; // pre-appending "direct" head to the reversed list
                current = head; // move head of reversed part to a new node
                head = tmp;
            }
            head = current;
        }
        return head;
    }
}
