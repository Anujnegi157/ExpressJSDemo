package Java_Codes.Dynamic_Programming;
class Solution{
  static int equalPartition(int N, int arr[])
  {
      // code here
      int sum =0;
      for(int val : arr){
          sum+=val;
      }
      if(sum%2!=0){
          return 0;
      }else{
           if(IsSum(arr,sum/2)){
               return 1;
           }
      }
      return 0;
  }
 static boolean IsSum(int [] nums,int tar){
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