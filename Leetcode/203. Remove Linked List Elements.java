/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        while(curr!= null && curr.val==val){
            head = head.next;
            curr = curr.next;
        }
        ListNode prev = curr;
        if(curr== null){
            return curr;
        }else{
            curr=curr.next;
        }
        while(curr!=null){
            int d = curr.val;
            if(d == val){
                curr=curr.next;
                continue;
            }
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
}