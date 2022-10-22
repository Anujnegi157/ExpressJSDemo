package ArrayAndStrings;
import java.util.*;
// import java.io.*;
public class SubarrayWithGivenSum {
  //{ Driver Code Starts


class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
     ArrayList<Integer> ans = new ArrayList<>();
     int i=-1;
     int j=-1;
     int sum=0;
     while(j<arr.length-1){
         if(sum==s){
             break;
         }
         while(j<arr.length-1 && sum<=s){
             j++;
             sum+=arr[j];
            //  System.out.println(sum);
             if(sum==s){
                 ans.add(i+2);
                 ans.add(j+1);
                 break;
             }
             
         }
         if(sum==s){
             break;
         }
         while(i<j && sum>s){
             i++;
            
            //  
            sum = sum-arr[i];
            //  System.out.println(sum);
            if(sum==s){
                 ans.add(i+2);
                 ans.add(j+1);
                 break;
             }
         }
         
         
         
     }
     
     if(ans.size()==0){
         ans.add(-1);
         return ans;
     }
     return ans;
    }
    
}
}
