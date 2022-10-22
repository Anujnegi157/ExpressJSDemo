public class UndirectedGraphCYclebydfs {
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       
    boolean [] vis = new boolean[V];
    for(int i=1;i<V;i++){
        if(vis[i]==false){
        if(is(adj,vis,i,-1)){
            return true;
        }
        }
    }
    return false;
 }
 public boolean is( ArrayList<ArrayList<Integer>> adj,boolean[] vis,int src,int pre){
     
     
     
     
     vis[src]=true;
     for(Integer val : adj.get(src)){
         // for(int val :arr){
             
             if(vis[val]==false){
                 boolean isans = is(adj,vis,val,src);
                 if(isans==true){
                     return true;
                 }
             }else if(val!=pre){
                 return true;
             }
         
     }
     return false;
     
 }
}
