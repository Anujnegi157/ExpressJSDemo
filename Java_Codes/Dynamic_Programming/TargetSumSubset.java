package Java_Codes.Dynamic_Programming;
import java.util.Scanner;


public  class TargetSumSubset{
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int  n = scn.nextInt();
    int [] arr= new int [n];
    for(int i=0;i<n;i++){
        
        arr[i]=scn.nextInt();
    }
    int tar= scn.nextInt();
    System.out.println(IsSum(arr,tar));
  }
  public static boolean IsSum(int [] nums,int tar){
   boolean [][] dp = new boolean[nums.length][tar+1];
   for(int index=0;index<nums.length;index++){
    for(int sum=0;sum<tar+1;sum++){
       if(sum==0){
        dp[index][sum]=true;
       }else if(index==0 && sum==nums[index]){
           dp[index][sum]=true;
       }else if(index>=1){
           boolean take = false;
           if(sum-nums[index]>=0){
            take = dp[index-1][sum-nums[index]];
           }
           boolean nottake = dp[index-1][sum];
           dp[index][sum] = take|| nottake;
       } 
    }
   }

   return dp[nums.length-1][tar];

  }
}