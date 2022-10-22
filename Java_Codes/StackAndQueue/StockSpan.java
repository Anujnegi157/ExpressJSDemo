import java.util.*;
import java.io.*;
import java.lang.*;
public class StockSpan {
  //{ Driver Code Starts




    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int [] ans = new int[n];
        ans[0]=1;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<price.length;i++){
            while(st.size()>0 && price[st.peek()]<=price[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;
            }else{
                // if(i==5){
                    // System.out.println(i+" "+ st.peek());
                // }
                ans[i]=i-st.peek();
            }
            st.push(i);
            
            
        }
        return ans;
    }
    
}

