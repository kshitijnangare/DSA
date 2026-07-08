/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
        if(headRef == null || headRef.next==null){
            return headRef;
        }
        Node curr = headRef;
        while(curr!=null && curr.next != null){
            if (curr.data == curr.next.data) {
                Node duplicate = curr.next;
                curr.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = curr;
                }
            } else {
                curr = curr.next;
            }
        }
        return headRef;
    }
}