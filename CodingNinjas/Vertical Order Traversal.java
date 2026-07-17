import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;
class Pair{
    TreeNode<Integer> node;
    int hd;
    Pair(TreeNode<Integer> node, int hd){
        this.node = node;
        this.hd=hd;
    }
}
public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){return list;}

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p =q.poll();
            int hd = p.hd;
            TreeNode<Integer> curr = p.node;
            map.computeIfAbsent(hd, k->new ArrayList<Integer>()).add(curr.data);
            if(curr.left!=null){
                q.add(new Pair(curr.left, hd-1));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, hd+1));
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
            for(int x: e.getValue()){
                list.add(x);
            }
        }
        return list;
    }
}
