import java.util.*; 
import java.io.*; 

public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        int carry = 0;
        LinkedListNode dummyHead = new LinkedListNode(0);
        LinkedListNode currentSumNode = dummyHead;
        
        while (head1 != null || head2 != null || carry > 0) {
            int digit1 = (head1 != null) ? head1.data : 0;
            int digit2 = (head2 != null) ? head2.data : 0;
            
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            int newDigit = sum % 10;
            
            currentSumNode.next = new LinkedListNode(newDigit);
            currentSumNode = currentSumNode.next;
            
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        
        return dummyHead.next;
    }
}