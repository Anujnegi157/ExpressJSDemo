import java.util.*;
public class SelectionSort {
  public static void main(String[] args) {
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=scn.nextInt();
    }
    selectionSort(arr);
    for(int i=0;i<n;i++){
      System.out.print(arr[i]+" ");
    }
  }
  // find min in array and reverse it with index
  public static void selectionSort(int [] arr){

    for(int i=0;i<arr.length;i++){
      int min = i;
      
      for(int j=i+1;j<arr.length;j++){
        // min = Math.min(min,arr[j]);
        if(arr[min]>arr[j]){
            min=j;
        }
      }
      int temp = arr[i];
      arr[i]=arr[min];
      arr[min]=temp;

    }


        

  }
}
