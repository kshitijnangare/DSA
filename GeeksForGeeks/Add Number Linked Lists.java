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
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        Node rev1 = reverseSLL(head1);
        Node rev2 = reverseSLL(head2);
        
        int carry = 0;
        Node dummyHead = new Node(0);
        Node currentSumNode = dummyHead;
        
        while(rev1 != null || rev2 != null || carry > 0){
            int digit1 = (rev1 != null)? rev1.data : 0;
            int digit2 = (rev2 != null)? rev2.data : 0;
            
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int newDigit = sum % 10;
            
            currentSumNode.next = new Node(newDigit);
            currentSumNode = currentSumNode.next;
            
            if(rev1 != null){
                rev1 = rev1.next;
            }
            if(rev2 != null){
                rev2 = rev2.next;
            }
        }
        
        Node resultHead = reverseSLL(dummyHead.next);
        
        while(resultHead != null && resultHead.data == 0 && resultHead.next != null){
            resultHead = resultHead.next;
        }
        return resultHead;
    }
    
    Node reverseSLL(Node head){
        Node curr = head;
        Node prev = null;
        Node Next;
        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
}