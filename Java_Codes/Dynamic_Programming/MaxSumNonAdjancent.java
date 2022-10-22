import java.util.*;
import java.io.*;
public class MaxSumNonAdjancent {
//{ Driver Code Starts
//Initial Template for Java





public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int inc =0;
        int exc =0;
        for(int i=0;i<n;i++){
            int nexl = Math.max(inc,exc);
            int ninc = exc+arr[i];
            inc = ninc;
            exc = nexl;
        }
        return Math.max(inc,exc);
    }
}
}
// } Driver Code Ends


//User function Template for Java




