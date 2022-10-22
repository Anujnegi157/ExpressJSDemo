public class Cycle2 {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if(head==null){
        return head;
    }
    if(left==right){
        return head;
    }
    int i=1;
    if(i==left){
        
    ListNode prev = null;

    ListNode curr= head;

    ListNode next = null ;

    while(i!=right){
        i++;

        next = curr.next;

        curr.next= prev;

        prev= curr;

        curr= next;

    }
        next=curr.next;
        head.next=next;
        curr.next=prev;
        return curr;
        
        
    }
   ListNode temp = head;
    
    while(temp!=null && i!=left-1){
        i++;
        temp= temp.next;
    }
    
    if(temp==null){
        return head;
    }
    ListNode first= temp;
    ListNode prev = null;
    ListNode last=temp.next;
    ListNode curr= temp.next;
    ListNode next = null ;
    i++;
    System.out.println(i);
    while(i!=right){
        i++;
        next = curr.next;
        curr.next= prev;
        prev= curr;
        curr= next;
    }
    
    next = curr.next;
    first.next=curr;
 //   head.next=curr;
    curr.next = prev;
    last.next=next;
    return head;
}
}
