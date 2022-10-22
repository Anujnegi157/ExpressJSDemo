public class NegativeCycle {
  public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int [] arr = new int [n];
        Arrays.fill(arr,100000000);
        arr[0]=0;
        // System.out.println(V);
        for(int i=1;i<n;i++){
            for(int [] arr1 : edges){
                int u = arr1[0];
                int v = arr1[1];
                int cost =arr1[2];
                if(arr[u]!=100000000){
                     arr[v]=Math.min(arr[v],arr[u]+cost);
                }
                
                
                
            }
        }
            for(int [] arr1 : edges){
                int u = arr1[0];
                int v = arr1[1];
                int cost =arr1[2];
                int temp = arr[v];
                if(arr[u]!=100000000){
                     arr[v]=Math.min(arr[v],arr[u]+cost);
                }
                if(temp!=arr[v]){
                    return 1;
                }
                
                
                
            }
            return 0;
       
    }
}
