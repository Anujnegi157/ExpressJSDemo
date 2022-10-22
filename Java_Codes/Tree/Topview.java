import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

public class Topview {
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

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}


class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair{
        
        Node node ;
        int  lev  ;
        Pair(){
            
        }
        Pair(Node node ,int lev){
            this.node = node;
            this.lev = lev;
        }
        
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        int [] arr = new int[2];
       

        Width(root,arr,0);
        int t= arr[1]-arr[0]+1;
        // System.out.println(t);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<t;i++){
            ans.add(null);
        }
        LinkedList<Pair> ll = new LinkedList<>();
        ll.add(new Pair(root,-arr[0]));
        while(ll.size()>0){
            
            Pair rem = ll.removeFirst();
            
            int level = rem.lev;
            if(ans.get(level)==null){
              ans.set(level,rem.node.data);
            }
            if(rem.node.left!=null){
                ll.addLast(new Pair(rem.node.left,level-1));
            }
             if(rem.node.right!=null){
                ll.addLast(new Pair(rem.node.right,level+1));
            }
            
            
            
        }
        return ans;
        
        
    }
    static void Width(Node root, int [] arr,int lev){
        
        if(root==null){
            return ;
        }
        arr[0]=Math.min(arr[0],lev);
        arr[1]=Math.max(arr[1],lev);
        
        
        Width(root.left,arr,lev-1);
        Width(root.right,arr,lev+1);
        
        
        
    }
}
}
//{ Driver Code Starts
//Initial Template for JAVA


