package Java_Codes.Tree;

import javax.swing.tree.TreeNode;
// package Java_Codes.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
public class levelOrder {
  public class TreeNode{
    int val;
    TreeNode  left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val,TreeNode left , TreeNode right){
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
 public static void level_traversal(int level,TreeNode root, List<List<Integer>>arr) {

  
  if(root==null){
    return ;
  }
  if(arr.size()==level){
    arr.add(new ArrayList<>());
  }
  arr.get(level).add(root.val);
  
  
  level_traversal(level+1,root.left,arr);
  level_traversal(level+1, root.right, arr);

  
 } 
}
