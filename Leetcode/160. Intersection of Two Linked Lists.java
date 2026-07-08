/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // int len1 = 1;
        // int len2 = 1;
        // if(headA == null || headB==null){
        //     return null;
        // }
        // if(headA==headB){
        //     return headA;
        // }
        // ListNode curr = headA;
        // while(curr!=null && curr.next!=null){
        //     curr= curr.next;
        //     len1++;
        // }
        // curr = headB;
        // while(curr!=null && curr.next!=null){
        //     curr = curr.next;
        //     len2++;
        // }
        // int diff = Math.abs(len1-len2);
        // ListNode curr2 = headA;
        // if(len1>len2){
        //     curr = headA;
        //     curr2=headB;      
        // }else{
        //     curr = headB;
        //     curr2 = headA;
        // }
        // while(diff-->0){
        //     curr = curr.next;
        // }
        // while(curr!=null){
        //     if(curr==curr2){
        //         return curr;
        //     }
        //     curr = curr.next;
        //     curr2 = curr2.next;
        // }
        // return null;

        if(headA == null || headB == null){
            return null;
        }
        
        ListNode curr1 = headA, curr2 = headB;
        
        while(curr1 != curr2){
            curr1 = (curr1==null) ? headB : curr1.next;
            curr2 = (curr2==null) ? headA : curr2.next;
        }
        
        return curr1;
    }
}