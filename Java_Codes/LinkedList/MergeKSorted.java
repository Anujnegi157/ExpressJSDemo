import java.util.*;

// public class MergeKSorted {
  //{ Driver Code Starts

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class MergeKSorted
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]lists,int K)
    {
          if(lists.length==0){
            return null;
        }
        if(lists.length== 1 && lists[0]==null){
            return null;
        }
        
        int n = lists.length;
        Node head=null;
        for(int i=0;i<lists.length;i++){
            head = MergeLL(head,lists[i]);
            // lists[i]=head;
            // n++;
        }
        return head;
        //Add your code here.
    }
     public Node MergeLL(Node l1,Node l2){
        Node head = new Node(-1);
        Node tail = head;
        Node h1 = l1;
        Node h2 =l2;
        while(h1!=null && h2!=null){
            if(h1.data<h2.data){
                tail.next = h1;
                h1=h1.next;
            }else{
                tail.next = h2;
                h2=h2.next; 
                
            }
            tail = tail.next;
        }
        if(h1==null){
          tail.next = h2;  
        }
        if(h2==null){
            tail.next = h1;
        }
        return head.next;
    }
}

// }
