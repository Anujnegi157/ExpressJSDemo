// public class ArrangeBuilding {
  //{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class ArrangeBuilding
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
      int build=1;
       int space=1;
       for(int i=2;i<=N;i++)
       {
           int x=space%1000000007;
           space=(space+build)%1000000007;
           build=x%1000000007;
       }
       long re=(long)((space+build)%1000000007);
       
       return (int)((re*re)%1000000007);
    }
}

