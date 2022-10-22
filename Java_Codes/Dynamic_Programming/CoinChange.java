package Java_Codes.Dynamic_Programming;

public class CoinChange {
  public static long count(int S[], int m, int n) {
    // code here.
   Long [][] dp = new Long[S.length+1][n+1];
//   Arrays.fill(dp,-1);
       return count1(S,0,n,dp);
}
public static long count1(int [] s,int i,int tar,Long [][] dp){
  if(tar<0){
      return 0;
  }
  if(tar==0){
      return 1;
  }
  if(i==s.length){
      if(tar==0){
      return 1;
  }
      return 0;
  }
  
if(dp[i][tar]!=null){
       return dp[i][tar];
}
 long take = count1(s,i,tar-s[i],dp);
 long not  = count1(s,i+1,tar,dp);
 dp[i][tar]= take+not;
 return take+not;
   
}
}
