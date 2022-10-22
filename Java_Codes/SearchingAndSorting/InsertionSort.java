import java.util.*;
public class InsertionSort {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=scn.nextInt();
    }
    InsertSort(arr);
    for(int i=0;i<n;i++){
      System.out.print(arr[i]+" ");
    }
  }
  public static void InsertSort(int []arr){

   for(int i=0;i<arr.length-1;i++){
    for(int j=i+1;j>=1;j--){
     if(arr[j-1]>arr[j]){
      int temp = arr[j];
      arr[j]=arr[j-1];
      arr[j-1]=temp;
     }else{
      break;
     }
    }
   }
   



  }
}
