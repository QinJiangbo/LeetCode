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
        if (lists.length == 0) { return null; }
        if (lists.length == 1) { return lists[0]; }
        int len = lists.length;
        int lo = 0, high = len - 1, mid = (high + lo) / 2;
        return partition(lists, lo, mid, high);
    }

    private ListNode partition(ListNode[] lists, int lo, int mid, int high) {
        // finished conditions
        if (high == mid + 1) {
            if (mid == lo) { return mergeTwoLists(lists[mid], lists[high]);}
            if (mid == lo + 1) {
                ListNode tmp = mergeTwoLists(lists[mid], lists[high]);
                return mergeTwoLists(lists[lo], tmp);
            }
        }
        // partition
        ListNode node1 = partition(lists, lo, (mid + lo) / 2, mid);
        ListNode node2 = partition(lists, mid + 1, (high + mid + 1) /2, high);
        return mergeTwoLists(node1, node2);
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
