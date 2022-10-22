import java.util.*;


public class Sort012 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<arr.length;i++){
      arr[i]=scn.nextInt();
    }
    sort012(arr);
    for(int val :arr){
      System.out.println(val);
    }
   
  }
  public static void sort012(int [] arr){
   int i=0;
   int j=0;
   int k = arr.length-1;
  //  0 to j-1 -> 0's Area
  // j to i-1 -> 1's Area
  // i to k -> 2's Unkwown
  // k+1 -> 2's Area
   while(i<=k){
   if(arr[i]==1){
     i++;
   }else if(arr[i]==0){
      int temp =arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
      i++;
      j++;

   }else {
    int temp =arr[k];
      arr[k]=arr[i];
      arr[i]=temp;
      k--;

   }

   }


  }
}
