package Java_Codes.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

class Node{
  int data;
  Node left;
  Node right;
  Node(){

  }

}
public class levelOrderSpiral {
  public static 
  ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
     
        ArrayDeque <Node> q = new ArrayDeque < > ();
        q.add(root);
        int lev=0;
        while (q.size() > 0) {
            int count = q.size();

         
           LinkedList<Integer> ll = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                //remove
               Node rem = q.remove();

                //work
               if(lev%2==0){
                    ll.addFirst(rem.data);
               }else{
                   ll.add(rem.data);
               }
              

                //add children
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }
            while(ll.size()>0){
                list.add(ll.removeFirst());
            }
            lev++;

           
            
        }
        return list;
        // Your code here
    }
}
