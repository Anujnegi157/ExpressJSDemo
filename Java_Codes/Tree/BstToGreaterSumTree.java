public class BstToGreaterSumTree {
  class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} 
  static int  sum =0;
  public static void transformTree (Node root)
  {
    Bst(root);
  }
  public static void Bst(Node root){

   if(root==null){
    return;
   }
   Bst(root.right);
   int val = root.val;
   root.val=sum;
   sum+=val;
   Bst(root.left);


  }

}
