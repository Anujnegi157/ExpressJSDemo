public class AddTwoNumber {
  //  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 
 
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
      int carry =0;
      ListNode head = new ListNode(-1);
      ListNode dummy=head;
      // head.next=dummy;
      int  number=0;
      while(l1!=null || l2!=null || carry>0){
           number=0;
           number+=carry;
          if(l1!=null){
              number+=l1.val;
              l1=l1.next;
          }
          if(l2!=null){
              number+=l2.val;
               l2=l2.next;
          }
          
           System.out.print(number);
          carry=number/10;
          ListNode h= new ListNode(number%10);
          dummy.next=h;
          dummy=dummy.next;
         
          
      }
      return head.next;
  }
}
}
