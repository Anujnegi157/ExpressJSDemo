// public class CountBinary {
  //{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class CountBinary {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        // code here
        long zero=1;
        long one = 1;
        for(int i=2;i<=n;i++){
            
            long newZero = one%1000000007l;
            long newOne  = (zero+one)%1000000007l;
            zero= newZero;
            one = newOne;
            
        }
        return (zero+one)%1000000007l;
    }
}
// }
