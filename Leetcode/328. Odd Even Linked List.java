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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode oddhead = null;
        ListNode evenhead = null;
        ListNode iterator = head;
        ListNode evenfirst = null;
        ListNode oddfirst = null;
        int i = 1;

        while(iterator!=null){
            if(i%2==0){
                if(evenhead==null){
                    evenhead = iterator; 
                    evenfirst = evenhead;
                }
                else{
                    evenhead.next = iterator;
                    evenhead = evenhead.next;
                }
            }else{
                if(oddhead==null){
                    oddhead = iterator; 
                    oddfirst = oddhead;
                }
                else{
                    oddhead.next = iterator;
                    oddhead = oddhead.next;
                }
            }
            iterator = iterator.next;
            i++;
        }
        oddhead.next = evenfirst;
        evenhead.next = null;
        return oddfirst;

    }
}