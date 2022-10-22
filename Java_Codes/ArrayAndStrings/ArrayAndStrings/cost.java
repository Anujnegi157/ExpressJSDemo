import java.util.*;

public class cost{
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(group(n));
  }
  public static class UnionFind{
    int [] rank;
    int [] par;
    UnionFind(){

    }
    UnionFind(int n){
      rank = new int [n+1];
      par  = new int [n+1];
      resize();
    }
     void resize(){
      for(int i=0;i<rank.length;i++){
        par[i]=i;
      }
      for(int i=0;i<par.length;i++){
        rank[i]=0;
      }
    }
     void union(int u,int v) {
      int slu = find(u);
      int slv = find(v);

      if(slu != slv) {
          int rslu = rank[slu];
          int rslv = rank[slv];

          if(rslu < rslv) {
              par[slu] = slv;
          }
          else if(rslv < rslu) {
              par[slv] = slu;
          }
          else {
              par[slu] = slv;
              rank[slv]++;
          }
      }
   } 
    int find(int x){

       if(par[x]==x){
          return x;
        }
       int temp = find(par[x]);
       par[x]=temp;
       return temp;
    }
   }
  public static int group(int n){
    UnionFind uf = new UnionFind(n+1);
    for(int k=2;k<=n+1;k++){

      for(int i=k;i<=n+1;i+=k){
        int u = k;
        int v = i;
          uf.union(u, v);
        
        
      }
    }
    int grp=0;
    for(int i=2;i<=n+1;i++){
      if(uf.par[i]==i){
        grp++;
      }
    }
    return grp;
  }
  
  
    

   
  
}