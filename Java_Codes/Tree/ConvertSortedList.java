/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
  public  ListNode Middle(ListNode head){
 ListNode slow = head;
 ListNode fast = head;
while(fast!=null && fast.next!=null && fast.next.next!=null && fast.next.next.next!=null){
 slow = slow.next;
 fast= fast.next.next;
}
return slow;

}
 public TreeNode sortedListToBST(ListNode head) {
 if(head==null){
         return null;
 }
 return MakeTree(head);
 }
 public TreeNode MakeTree(ListNode head){
 if(head==null){
   return null;
 }
 if(head.next==null){
     return new TreeNode(head.val);
 }


 ListNode mid = Middle(head);
 ListNode makeNode= mid.next;
   
  TreeNode root = new TreeNode(makeNode.val);
  ListNode next = makeNode.next;
  mid.next = null;
  makeNode.next=null;

       root.left = MakeTree(head);
  
 
  root.right = MakeTree(next);
  return root;



}
}