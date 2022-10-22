import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 

public class SortAccToA2 {
  //{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */



// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        // System.out.println("hello");
        HashMap<Integer,Integer> st = new HashMap<>();
        for(int val:A1){
           int fq = st.getOrDefault(val,0)+1;
           st.put(val,fq);
        }
        // System.out.println(st);
        int [] ans = new int[A1.length];
        int i=0;
        for(int val:A2){
            if(st.containsKey(val)){
                int fq = st.get(val);
                while(fq>0){
                    ans[i]=val;
                    i++;
                    fq--;
                }
                st.remove(val);
            }
        }
    //   // System.out.println("bug");
        int stt=i;
        // System.out.println(ans[i-1]);
        // System.out.println(st);
        for(int key:st.keySet()){
            // System.out.println(key);
             int fq = st.get(key);
             
             while(fq>0){
                 ans[i]=key;
                 i++;
                 fq--;
             }
            //  st.remove(key);
              
            //  System.out.println(fq);
        }
        // System.out.println(st);
        // for(int val:st.keySet()){
        //    
        //     while(fq>0){
        //         ans[i]=val;
        //         fq--;
        //         i++;
        //     }
        //    
        // }
        Arrays.sort(ans,stt,ans.length);
        return ans;
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends
}
