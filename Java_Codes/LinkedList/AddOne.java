public class AddOne{
  class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
  } 
// public static Node  AddOne(Node head) {
  public static Node addOne(Node head) 
  { 
      //code here.
      if(head==null){
          return null;
      }
      return AddOne(head);
  }
  public static Node  AddOne(Node head) {

Node rev = ReverseNode(head);

int carry = 1;
Node curr = rev;
Node prev = null;
while(curr!=null || carry==1){
   int sum=0;
   if(curr!=null){
   sum+=curr.data;
  }
  sum+=carry;
  
  int c = sum/10;
  int v = sum%10;
  if(curr==null){
    prev.next = new Node(v);
  }else{
    curr.data = v;
  }
  prev = curr;
  if(curr!=null){
  curr=curr.next;
  }
  carry = c;

}
Node shit = ReverseNode(rev);
return shit;

}
public static Node  ReverseNode(Node head) {
Node curr = head;
Node prev = null;
while(curr!=null){
Node next = curr.next;
curr.next = prev;
prev=curr;
curr=next;

}
return prev;

}
}