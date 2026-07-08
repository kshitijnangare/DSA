/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        if (head == null) {
            return null;
        }

        Node curr = head;
        
        while (curr != null) {
            if (curr.data == x) {
                if (curr == head) {
                    head = curr.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    if (curr.prev != null) {
                        curr.prev.next = curr.next;
                    }
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                }
            }
            curr = curr.next;
        }
        
        return head;
    }
}