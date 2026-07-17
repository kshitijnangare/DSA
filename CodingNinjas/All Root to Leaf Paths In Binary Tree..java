/********************************************************************

 Following is the class structure of the Node class:

 class BinaryTreeNode {
     int data;
     BinaryTreeNode left;
     BinaryTreeNode right;

     BinaryTreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 };

 ********************************************************************/
import java.util.*;
public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        StringBuilder temp = new StringBuilder();
        recur(root, list, temp);
        return list;
    }

    static void recur(BinaryTreeNode node, List<String> list, StringBuilder temp) {
        if (node == null) {
            return;
        }
        int lengthBeforeAppend = temp.length();
        temp.append(node.data).append(" ");
        if (node.left == null && node.right == null) {
            list.add(temp.toString().trim());
        } else {
            recur(node.left, list, temp);
            recur(node.right, list, temp);
        }
        temp.setLength(lengthBeforeAppend);
    }
}