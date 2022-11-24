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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }
        
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop();
            }
            int num2 = 0;
            if (!stack2.isEmpty()) {
                num2 = stack2.pop();
            }
            ListNode newNode = new ListNode((num1 + num2 + carry) % 10);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            carry = (num1 + num2 + carry) / 10;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }
        
        return dummyHead.next;
    }
}
