public class CreateTreeFromPreAndIn {
  public class TreeNode{
    int val;
    TreeNode left; 
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val, TreeNode left,TreeNode right){
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    idx=0;
   return MakeTree(inorder,preorder,0,inorder.length-1); 
  }
  int idx=0;
   public TreeNode MakeTree(int [] in, int [] pre , int lo, int  hi ){

   if(lo>hi){
   return null;
  }
 int value = pre[idx];
 int find = lo;
 while(in[find]!=value){
    find++;
 }
 idx++;
 TreeNode root = new TreeNode(value);
 root.left = MakeTree(in, pre, lo, find-1);
 root.right = MakeTree(in, pre, find+1, hi);
 return root;

}
}
