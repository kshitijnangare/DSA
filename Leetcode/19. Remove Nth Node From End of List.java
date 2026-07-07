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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode ahead = dummy;
        ListNode behind = dummy;
        dummy.next = head;
        while(n-->=0){
            ahead = ahead.next;
        }
        while(ahead!=null){
            ahead=ahead.next;
            behind = behind.next;
        }
        ListNode delete = behind.next;
        ListNode nxt = delete.next;
        behind.next = nxt;
        delete.next = null;
        return dummy.next;
    }
}