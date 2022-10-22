public class RemoveDuplicateUnsorted {
  public Node removeDuplicates(Node head) 
    {
        if(head ==null || head.next==null){
            return head;
        }
        HashSet<Integer> hp = new HashSet<>();
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            
            if(hp.contains(curr.data)){
                prev.next = curr.next;
                curr=prev.next;
            }else{
                hp.add(curr.data);
                prev = curr;
                curr= curr.next;
            }
            
        }
        return head;
        
        // Your code here
    }
}
