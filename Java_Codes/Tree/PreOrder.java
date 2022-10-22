public class PreOrder {
  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> st = new Stack<>();
// TreeNode root = new TreeNode(-1);
List<Integer> st1 = new ArrayList<>();

TreeNode head = root;
AddLeft(root,st,st1);
while(st.size()>0){
 TreeNode right = st.pop();

 AddLeft(right.right,st,st1);
   
}
   return st1;
}
public  void AddLeft(TreeNode curr,Stack<TreeNode> st,List<Integer> st1) {

while(curr!=null){
st1.add(curr.val);
 st.add(curr);
 curr=curr.left;
}

}
}
