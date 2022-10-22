package Java_Codes.Dynamic_Programming;


public class MIN_PARTITON_SUBSET
{
    
	public int minDifference(int arr[], int n) 
	{ 
	    
	    int sum=0;
	    for(int i=0;i<arr.length;i++){
	        sum+=arr[i];
	       // System.out.println(sum);
	    }
	   
	    boolean [][] dp = IsSum(arr,sum);
	    boolean [] lastdp = dp[arr.length-1];
	    int diff = Integer.MAX_VALUE;
	    
	   
	    for(int i=0;i<lastdp.length;i++){
	        if(lastdp[i]==true){
	            int s1=sum-i;
	            if(i>s1){
	                
	                diff = Math.min(diff,i-s1);
	            }else{
	                diff = Math.min(diff,s1-i);
	            }
	        }
	    }
	    return diff;
	    
	} 
public boolean[][] IsSum(int [] nums,int tar){
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

   return dp;

  }
	
}
