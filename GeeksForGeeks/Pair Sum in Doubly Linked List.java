/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        ArrayList<ArrayList<Integer>> res  = new ArrayList<>();
        while(head.data < tail.data){
            int h = head.data;
            int t= tail.data;
            int sum = h+t;
            if(sum == target){
                res.add(new ArrayList<Integer>(Arrays.asList(h,t)));
                head = head.next;
                tail = tail.prev;
            }else if(sum<target){
                head = head.next;
            }else{
                tail = tail.prev;
            }
            
        }
        return res;
        
    }
}
