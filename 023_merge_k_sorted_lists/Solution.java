/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /*
    Solution: Almost identical to #021.
        - Time complexity: O(n log(k))
        - Space complexity: O(1)
     */

    public class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        /*
        130 / 130 test cases passed.
        Status: Accepted
        Runtime: Your runtime beats 57.87% of java submissions.
         */

        ListNode head = new ListNode(-1);
        ListNode ptr = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ListNodeComparator());

        for(ListNode n : lists)
            if(n != null) pq.offer(n);

        while(!pq.isEmpty()) {
            ptr.next = pq.poll();
            if(ptr.next.next != null)
                pq.offer(ptr.next.next);
            ptr = ptr.next;
        }

        return head.next;
    }
}