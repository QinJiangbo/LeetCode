
/**
 * @date: 02/03/2017 9:04 PM
 * @author: qinjiangbo@github.io
 * @description:
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

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


    public static void main(String[] args) {
        AddTwoNum addTwoNum = new AddTwoNum();
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        System.out.println(addTwoNum.addTwoNumbers(node1, node2).next.val);

    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
