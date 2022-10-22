public class OutOfBoundaryPath {
  class Solution {
    int [][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    int modulo=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer [][][] dp = new Integer[m][n][maxMove+1];
        return TotalCount(startRow,startColumn,0,maxMove,m,n,dp);
    }
    public int TotalCount(int i,int j,int totalStep,int max,int m , int n,Integer[][][] dp){
        if(totalStep<=max){
            if(i<0 || j<0 || i>=m || j>=n){
            return 1;
         }
        }else{
            return 0;
        }
        if(dp[i][j][totalStep]!=null){
            return dp[i][j][totalStep];
        }
       
        int total=0;
        for(int k= 0;k<dir.length;k++){
            int nr = i+dir[k][0];
            int nc = j+dir[k][1];
            total=(total+TotalCount(nr,nc,totalStep+1,max,m,n,dp))%modulo;
            
        }
        dp[i][j][totalStep]= total%modulo;
        return total%modulo;
        
        
    }
}
}
