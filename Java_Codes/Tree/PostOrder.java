public class PostOrder {
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
       Stack<TreeNode> st = new Stack<>();
  // TreeNode root = new TreeNode(-1);
  LinkedList<Integer> st1 = new LinkedList<>();
  
  TreeNode head = root;
  AddLeft(root,st,st1);
      
  while(st.size()>0){
    TreeNode right = st.pop();
    
    AddLeft(right.left,st,st1);
    
   
      
  }
      return st1;
  }
  public void AddLeft(TreeNode curr,Stack<TreeNode> st,LinkedList<Integer> st1) {

  while(curr!=null){
    st1.addFirst(curr.val);
    st.add(curr);
    curr=curr.right;
  }
  
}
}
}
