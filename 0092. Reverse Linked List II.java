/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode forw = cur.next;
            cur.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
        }
        return dummyHead.next;
    }
}
