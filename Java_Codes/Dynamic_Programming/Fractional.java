package Java_Codes.Dynamic_Programming;

import java.util.Arrays;

public class Fractional {
  public class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
    
}
class Pair implements Comparable<Pair>{
  int wt;
  int val;
  double r;
        
        Pair(int wt,int val) {
            this.wt = wt;
            this.val = val;
            this.r = (val * 1.0) / wt;
        }
        
        public int compareTo(Pair o) {
            if(this.r < o.r) {
                return -1;
            }
            else if(this.r > o.r) {
                return 1;
            }
            else {
                return 0;
            }
        }

}
  public static double fractionalKnapsack(int W, Item arr[], int n) 
    {
         
      Pair [] items = new Pair[arr.length];
      for(int i=0; i < n;i++) {
        items[i] = new Pair(arr[i].weight,arr[i].value);
      }
    
       Arrays.sort(items);


       int rc = W;
       double mp = 0.0;
       for(int i = n-1; i >= 0;i--) {
        Pair p = items[i];
        
        if(p.wt <= rc) {
            rc -= p.wt;
            mp += p.val;
        }
        else {
            mp += p.r * rc;
            rc = 0;
        }
    }
    
    return mp;
        // Your code here
    }
}
