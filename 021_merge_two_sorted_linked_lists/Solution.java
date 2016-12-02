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
    Semi-optimal solution: Although it's possible to do this with less space by not using a Heap / Priority Queue and just keeping pointers to ListNodes, I think this is the most elegant and most scalable solution.
    Heaps / Priority Queues typically have a runtime complexity of O(n Log(n)), making them slower than linear time O(n) algorithms.
    However, the Log(n) portion of the runtime is due to having to constantly order the new elements; if we know that we'll only keep a maximum of 2 elements in the heap at any given point of time, the runtime becomes O(n log(2)), which is effectively O(n).

    This same algorithm can be scaled to merge any number of linked lists, in which case the runtime becomes O(n log(k)), where k is the number of LinkedLists you wish to merge.
     */

    public class ListNodeComparator implements Comparator<ListNode> {
        /* We must override the comparator because the Priority Queue wouldn't know how to compare two ListNodes otherwise. */
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        /* Cap the size of the priority queue at 2. */
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(2, new ListNodeComparator());

        while(!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if(nextNode.next != null) {
                pq.offer(nextNode.next);
            }
        }

        return head.next;
    }

}