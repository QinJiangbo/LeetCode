package MergeKSortedLists;

import Commons.ListNode;

/**
 * @date: 13/03/2017 10:02 PM
 * @author: qinjiangbo@github.io
 * @description:
        Merge k sorted linked lists and return it as one sorted list.
        Analyze and describe its complexity.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        int lo = 0, high = len -1, mid = (high - lo + 1) / 2;
        return partition(lists, lo, mid, high);
    }

    private ListNode partition(ListNode[] lists, int lo, int mid, int high) {
        return null;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        ListNode node;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            node = l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            node = l2;
        }
        return node;
    }
}
