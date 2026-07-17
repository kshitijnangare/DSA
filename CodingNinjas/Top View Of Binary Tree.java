/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null){return list;}
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode curr = p.node;
            int hd = p.hd;
            if(!map.containsKey(hd)){
                map.put(hd, curr.data);
            }
            if(curr.left!=null){
                q.add(new Pair(curr.left, hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, hd+1));
            }
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }
}
