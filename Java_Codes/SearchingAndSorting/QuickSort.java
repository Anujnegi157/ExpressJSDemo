import java.util.*;
public class QuickSort {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int [n];
    for(int i=0;i<arr.length;i++){
      arr[i]=scn.nextInt();
    }
    QuickSort1(arr,0,arr.length-1);
    for(int val :arr){
      System.out.println(val);
    }
  }
  public static int Partiton(int [] arr,int ele,int lo,int hi){
     
    int i=lo;
    int j=lo;

    while(j<=hi){
     
      if(arr[j]>ele){
        j++;
      }else{
       int temp = arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
       j++;
       i++;


      }


    }
    return i-1;

  }
  public static void QuickSort1(int []arr,int lo,int hi){
    
    if(lo>=hi){
      return;
    }

    int pivot = arr[hi];
    int pi = Partiton(arr,pivot,lo,hi);
    QuickSort1(arr, lo, pi-1);
    QuickSort1(arr, pi+1, hi);
  }
}
