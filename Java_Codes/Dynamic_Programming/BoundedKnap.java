package Java_Codes.Dynamic_Programming;

public class BoundedKnap {
  public static void main(String [] args) {
      int N = 3;
      int W = 3;
      int values[] = {1,2,3};
      int weight[] = {4,5,6};
      System.out.println(Knap01_tab( weight, values, W));
    
  }
  public static int knapSack(int W, int wt[], int val[], int n) 
    { 
         
      
         // your code here 
         Integer [][] dp = new Integer[wt.length][W+1];
          return Knap01(wt,0,W,val,dp);
    }
    public static  int Knap01(int [] wt,int i,int W,int [] val,Integer[][] dp){
      if(W==0){
        return 0;
      }
      if(i==wt.length){
        return 0;
      }
      if(dp[i][W]!=null){
          return dp[i][W];
      }
      int take=0;
      if(W-wt[i]>=0){
         take = Knap01(wt, i+1, W-wt[i], val,dp)+val[i];
      }
      int nottake=Knap01(wt, i+1, W, val,dp);
      dp[i][W]= Math.max(take, nottake);
      return Math.max(take, nottake);

}
   //  Tabulations
public static int Knap01_tab(int [] wt,int [] val,int W) {

  int [][] dp = new int[wt.length][W+1];
  
   for(int i=0;i<dp.length;i++){
    for(int j=0;j<dp[i].length;j++){
       if(i==0){
          if(j-wt[i]>=0){
            dp[i][j]=val[i];
          }
       }else{
          int take = 0;
          if(j-wt[i]>=0){
            take=val[i]+dp[i-1][j-wt[i]];
          }
          int nottake = dp[i-1][j];
          dp[i][j]=Math.max(take, nottake);



       }

    }
   }




  return dp[val.length-1][W];
  
}

}
