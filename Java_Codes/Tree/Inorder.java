import java.util.Stack;

public class Inorder {
  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right ;
    TreeNode(){

    }
    TreeNode(int val ,TreeNode left , TreeNode right){
      this.val = val;
      this.left =  left;
      this.right = right;
    }
  }
  public static void main(String[] args) {
    Stack<TreeNode> st = new Stack<>();
    // TreeNode root = new TreeNode(-1);
    List<Integer> st1 = new ArrayList<>();
    
    TreeNode head = root;
    AddLeft(root,st);
    while(st.size()>0){
      TreeNode right = st.pop();
      st1.add(right.val);
      AddLeft(right.right,st);
        
    }
        return st1;
  }
  public static  void AddLeft(TreeNode curr,Stack<TreeNode> st) {

    while(curr!=null){
      st.add(curr);
      curr=curr.left;
    }
    
  }
}
