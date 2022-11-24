/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node pseudoHead = new Node(0, null, head, null);
        flattenDFS(pseudoHead, head);
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    public Node flattenDFS(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        
        return flattenDFS(tail, tempNext);
    }
}
