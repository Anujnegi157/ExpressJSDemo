package Java_Codes.Dynamic_Programming;



public class UnboundedKnapsack {
  public static int  UnboundedKnapsack_tab(int [] wt,int [] val,int W) {
    int [] dp = new int[W+1];
    // i looop val
    // w loop wt
    for(int i=0;i<wt.length;i++){        
      for(int w=0;w<dp.length;w++){
        if(w-wt[i]>=0){
         int prev = dp[w];
         int now = dp[w-wt[i]]+val[i];
         dp[w]=Math.max(prev,now);

        }

      }
    }
    return dp[W];
    
  }
  public static void main(String[] args) {

    int N = 2, W = 3;
int val[] = {1, 1};
int wt[] = {2, 1};
    System.out.println(UnboundedKnapsack_tab(wt,val,W));
  }
 public  static int knapSack(int N, int W, int val[], int wt[])
  {
    // Integer [][] dp = new Integer[wt.length][W+1];
    return UnboundedKnapsack_tab(wt, val, W);
    // return knapSack_unbounded(wt, val, W, 0,dp);

      // code here
  }
  public static int knapSack_unbounded(int [] wt,int [] val,int  W,int i,Integer[][] dp) {
    
    if(W==0){
      return 0;
    }
    if(i==wt.length){
      return 0;
    }
    if(dp[i][W]!=null){
        return dp[i][W];
    }
    int take = 0;
    if(W-wt[i]>=0){
      take=knapSack_unbounded(wt, val, W-wt[i],i,dp)+val[i];
    }
    int nottake = knapSack_unbounded(wt, val, W, i+1,dp);
   dp[i][W]=Math.max(take, nottake);
    return Math.max(take, nottake);
    
  }
}
