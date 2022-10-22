import java.util.*;
public class MergeSort {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=scn.nextInt();
    }
    int [] ans =mergeSort(arr,0,arr.length-1);
    for(int i=0;i<n;i++){
      System.out.print(ans[i]+" ");
    }
  }
  public static int[] mergeSort(int [] arr,int lo,int hi){
    if(lo==hi){
      int [] ba = new int [1];
      ba[0]=arr[lo];
      return ba;
    }
    int mid = (lo+hi)/2;
    int [] a = mergeSort(arr, lo, mid);
    int [] b = mergeSort(arr, mid+1, hi);

    int [] sortedArr = MergeArray(a, b);
    return sortedArr;
  }
  public static int[] MergeArray(int [] a, int [] b){
    int i = 0, j = 0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i<a.length && j<b.length){
       if(a[i]<b[j]){
        ans[k]=a[i];
        i++;
        k++;
       }else{
        ans[k]=b[j];
        j++;
        k++;
       }

    }
    if(i==a.length){
while(j<b.length){
  ans[k]=b[j];
  j++;
  k++;
}
    }
    if(j==b.length){
      while(i<a.length){
        ans[k]=a[i];
        i++;
        k++;
      }

    



  }
  return ans;
}
}
