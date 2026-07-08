/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        if(firstHead == null || secondHead == null){
            return 0;
        }
        
        Node curr1 = firstHead, curr2 = secondHead;
        
        while(curr1 != curr2){
            curr1 = (curr1==null) ? secondHead : curr1.next;
            curr2 = (curr2==null) ? firstHead : curr2.next;
        }
        
        return curr1.data;
    }
}