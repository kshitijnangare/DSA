import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node addOne(Node head) {
		// Write your code here.
		int carry = addOneUtil(head);
        if (carry != 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }
        
    static int addOneUtil(Node node) {
        if (node == null) return 1;
        int carry = addOneUtil(node.next);  
        int sum = node.data + carry;
        node.data = sum % 10;
        return sum / 10;  
    }
}