package code2;

/**
 * @date: 02/03/2017 9:04 PM
 * @author: qinjiangbo@github.io
 * @description:
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order and each of their nodes contain a single digit.
        Add the two numbers and return it as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Examples:
            Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
            Output: 7 -> 0 -> 8
 */
public class AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prevNode = new ListNode(0);
        ListNode headNode = prevNode;
        int decimal = 0;
        while (l1 != null || l2 != null || decimal != 0) {
            ListNode currNode = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + decimal;
            int remainder = sum % 10;
            decimal = sum / 10;
            currNode.val = remainder; // Here is reverse
            prevNode.next = currNode;
            prevNode = currNode;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return headNode.next;
    }
}

