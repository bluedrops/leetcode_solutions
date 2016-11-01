/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /*
        1559 / 1559 test cases passed.
        Status: Accepted
        Runtime: Your runtime beats 98.05% of java submissions.
        */

        ListNode head = new ListNode(0);
        ListNode ptr = ret;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int value = carry;

            if(l1 != null) value += l1.val;
            if(l2 != null) value += l2.val;

            ListNode digit = new ListNode(value);
            carry = 0;

            if(digit.val > 9) {
                digit.val = digit.val-10;
                carry = 1;
            }

            ptr.next = digit;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            ptr = ptr.next;
        }

        if(carry != 0) {
            ListNode digit = new ListNode(carry);
            ptr.next = digit;
        }

        return head.next;
    }
}
