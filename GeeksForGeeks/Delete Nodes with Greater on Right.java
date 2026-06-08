/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        // code here
        if(head.next==null){
            return head;
        }
        head = reverse(head);
        Node curr = head.next;
        Node prev = head;
        while(curr!=null){
            int prevData = prev.data;
            int currData = curr.data;
            if(currData>=prevData){
                prev.next=curr;
                prev=curr;
            }
            curr = curr.next;
        }
        prev.next=null;
        
        head = reverse(head);
        return head;
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }
}