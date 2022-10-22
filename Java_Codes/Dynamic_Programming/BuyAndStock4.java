public class BuyAndStock4 {
  public int maxProfit(int [] prices , int k){
    int s = 2*k+1;
    int []curr = new int [s];
    int []After = new int [s];
    for(int i=prices.length-1;i>=0;i--){
        for(int transNo=2*k-1;transNo>=0;transNo--){
            
            if(transNo%2==0){
              curr[transNo]=Math.max(-prices[i]+After[transNo+1],0+After[transNo]);
            }else{ 
              curr[transNo]=Math.max(prices[i]+After[transNo+1],0+After[transNo]);
            }
            
            
        }
        After = curr;
    }
    return After[0];
    
}
  class Solution {
    public int maxProfit(int k, int[] prices) {
         Integer [][][]  dp = new Integer[2][k+1][prices.length];
    
    return maxProfit(prices,0,0,dp,0,k);
    }
    public int maxProfit(int [] prices,int i, int state,Integer[][][] dp,int trans,int k){
    
if(trans==k){
     return 0;
}
if(i==prices.length){
     if(trans==k){
        return 0;
    }
    return 0;
}
if(dp[state][trans][i]!=null){
    return dp[state][trans][i];
}
int profit = 0;
// 0 denote for buy
if(state == 0){
  profit = Math.max(-prices[i]+maxProfit(prices,i+1,1,dp,trans,k),0+maxProfit(prices,i+1,0,dp,trans,k));
    
}else{
      profit = Math.max(prices[i]+maxProfit(prices,i+1,0,dp,trans+1,k),0+maxProfit(prices,i+1,1,dp,trans,k));
    
    
}
dp[state][trans][i]=profit;
return profit;
// 1 denote for sell


}
}
}
