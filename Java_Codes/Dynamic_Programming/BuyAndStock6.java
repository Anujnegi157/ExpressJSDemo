public class BuyAndStock6 {
  public  int maxProfit1(int [] prices,int fee){
        
    int AheadNotBuy=0;
    int AheadBuy =0;
    for(int i=prices.length-1;i>=0;i--){
        
        int currBuy = Math.max(-prices[i]+AheadNotBuy,0+AheadBuy);
        int currNotBuy = Math.max(prices[i]-fee+AheadBuy,0+AheadNotBuy);
        
        AheadNotBuy = currNotBuy;
        
        AheadBuy = currBuy;
        
        
    }
    return AheadBuy;
    
    
    
    
}
  class Solution {
    public int maxProfit(int[] prices, int fee) {
         Integer [][]  dp = new Integer[2][prices.length];
    
    return maxProfit(prices,0,0,dp,fee); 
    }
     public int maxProfit(int [] prices,int i, int state,Integer[][] dp,int fee){
        
    if(i>=prices.length){
        return 0;
    }
    if(dp[state][i]!=null){
        return dp[state][i];
    }
    int profit = 0;
    // 0 denote for buy
    if(state == 0){
      profit = Math.max(-prices[i]+maxProfit(prices,i+1,1,dp,fee),0+maxProfit(prices,i+1,0,dp,fee));
        
    }else{
          profit = Math.max(prices[i]-fee+maxProfit(prices,i+1,0,dp,fee),0+maxProfit(prices,i+1,1,dp,fee));
        
        
    }
    dp[state][i]=profit;
    return profit;
    // 1 denote for sell
    
    
}
}
}
