public class BuyAndStock5 {
  public int maxProfit1(int [] prices){
        
    int[] curr = new int [2];
    int[] front1 = new int [2];
    int []front2 = new int [2];
    for(int i=prices.length-1;i>=0;i--){
        for(int buy =0;buy<=1;buy++){
            int profit=0;
            if(buy==0){
                 profit=Math.max(-prices[i]+front1[1],0+front1[0]);
            }else{
                 profit=Math.max(prices[i]+front2[0],0+front1[1]);
            }
            curr[buy]=profit;
       
        }
       front2 = (int[])(front1.clone());
    front1 = (int [])(curr.clone());
        
    }
    return curr[0];
}
  class Solution {
    public int maxProfit(int[] prices) {
        Integer [][]  dp = new Integer[2][prices.length];
    
    return maxProfit(prices,0,0,dp); 
    }
    public int maxProfit(int [] prices,int i, int state,Integer[][] dp){
        
    if(i>=prices.length){
        return 0;
    }
    if(dp[state][i]!=null){
        return dp[state][i];
    }
    int profit = 0;
    // 0 denote for buy
    if(state == 0){
      profit = Math.max(-prices[i]+maxProfit(prices,i+1,1,dp),0+maxProfit(prices,i+1,0,dp));
        
    }else{
          profit = Math.max(prices[i]+maxProfit(prices,i+2,0,dp),0+maxProfit(prices,i+1,1,dp));
        
        
    }
    dp[state][i]=profit;
    return profit;
    // 1 denote for sell
    
    
}
}
}
