import java.util.*;
public class RateInMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> ans ;
    public static ArrayList<String> findPath(int[][] m, int n) {
        ans = new ArrayList<>();
        boolean [][] vis = new boolean [n][n];
        paths(0,00,vis,m,"");
        return ans;
        // Your code here
    }
    public static void paths(int i,int j,boolean [][] vis,int [][] m,String s){
        
        
        
        if(i<0 || i>=m.length || j<0 || j>=m[0].length || vis[i][j]==true || m[i][j]==0){
            return ;
        }
        if(i==m.length-1 && j==m[0].length-1){
            ans.add(s);
        }
        vis[i][j]=true;
        
        paths(i-1,j,vis,m,s+"U");
        paths(i+1,j,vis,m,s+"D");
        paths(i,j-1,vis,m,s+"L");
        paths(i,j+1,vis,m,s+"R");
        vis[i][j]= false;
    }
}

