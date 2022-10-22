public class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {
    boolean [][] vis = new boolean[grid.length][grid[0].length];
    int max = 0;
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1  && vis[i][j]==false){
              int ht = shit(grid,vis,i,j);
                if(max<ht){
                    max=ht;
                    // System.out.println(max);
                }
            }
        }
    }
    
    return max;
}
 public int shit(int [][] matrix,boolean [][] vis,int i,int j){
    
    if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || vis[i][j]==true || matrix[i][j]==0){
        return 0;
    }
    
    vis[i][j]=true;
   
   int a = shit(matrix,vis,i-1,j);
   int b= shit(matrix, vis, i, j-1);
  int c=   shit(matrix, vis,i+1, j);
  int d=  shit( matrix, vis, i, j+1);
     int ans = a+b+c+d+1;
     
     return ans;
}
}
