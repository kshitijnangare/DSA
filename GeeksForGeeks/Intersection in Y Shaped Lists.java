/*
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
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if(head1 == null || head2 == null){
            return null;
        }
        
        Node curr1 = head1, curr2 = head2;
        
        while(curr1 != curr2){
            curr1 = (curr1==null) ? head2 : curr1.next;
            curr2 = (curr2==null) ? head1 : curr2.next;
        }
        
        return curr1;
        
    }
}