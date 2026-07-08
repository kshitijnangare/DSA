/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        // code here.
        int carry = addOneUtil(head);
        if (carry != 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }
        
    int addOneUtil(Node node) {
        if (node == null) return 1;
        int carry = addOneUtil(node.next);  
        int sum = node.data + carry;
        node.data = sum % 10;
        return sum / 10;  
    }
}