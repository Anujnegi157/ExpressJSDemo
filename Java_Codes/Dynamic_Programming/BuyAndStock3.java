public class BuyAndStock3 {
  class Solution {
    public int maxProfit(int[] prices) {
        Integer [][]  dp = new Integer[prices.length][4];
        
        return maxProfit(prices,0,0,dp,0);
    }
    public int maxProfit(int [] prices,int i, int state,Integer[][] dp,int trans){
        
    if(trans==4){
         return 0;
    }
    if(i==prices.length){
         if(trans==4){
            return 0;
        }
        return 0;
    }
    if(dp[i][trans]!=null){
        return dp[i][trans];
    }
    int profit = 0;
    // 0 denote for buy
    if(trans%2==0){
      profit = Math.max(-prices[i]+maxProfit(prices,i+1,1,dp,trans+1),0+maxProfit(prices,i+1,0,dp,trans));
        
    }else{
          profit = Math.max(prices[i]+maxProfit(prices,i+1,0,dp,trans+1),0+maxProfit(prices,i+1,1,dp,trans));
        
        
    }
    dp[i][trans]=profit;
    return profit;
    // 1 denote for sell
    
    
}
}
  public int maxProfit(int[] prices) {
    Integer [][][]  dp = new Integer[2][2][prices.length];
    
    return maxProfit(prices,0,0,dp,0);
}
public int maxProfit(int [] prices,int i, int state,Integer[][][] dp,int trans){
    
if(trans==2){
     return 0;
}
if(i==prices.length){
     if(trans==2){
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
  profit = Math.max(-prices[i]+maxProfit(prices,i+1,1,dp,trans),0+maxProfit(prices,i+1,0,dp,trans));
    
}else{
      profit = Math.max(prices[i]+maxProfit(prices,i+1,0,dp,trans+1),0+maxProfit(prices,i+1,1,dp,trans));
    
    
}
dp[state][trans][i]=profit;
return profit;
// 1 denote for sell


}
}
