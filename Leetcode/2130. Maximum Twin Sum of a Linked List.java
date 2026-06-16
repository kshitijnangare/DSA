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

    // appraoch 1: storing in a stack and then popping out

    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        temp = head;
        for(int i = 0; i<n/2; i++){
            temp = temp.next;
        }
        for(int i = n/2; i<n; i++){
            st.push(temp.val);
            temp = temp.next;
        }
        int max = 0;
        temp = head;
        for(int i = 0; i<n/2; i++){
            max = Math.max(max, temp.val+st.pop());
            temp = temp.next;
        }
        return max;

    }

    // approach 2 reversing the half of the linkedList
}