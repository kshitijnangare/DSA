/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
import java.util.*;
import java.lang.*;
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode<Integer> curr = q.poll();
                if(i==0){
                    System.out.print(curr.data+" ");
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    q.add(curr.right);
                }
            }
        }
    }
}
