import java.util.*;
public class CountNo1 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int []arr = new int[n];
    for(int i=0;i<arr.length;i++){
      arr[i]=scn.nextInt();
    }
    if(arr[0]==1){
      System.out.println("0");
    }
    if(arr[n-1]==0){
      System.out.println("-1");
    }
    System.out.println(Binary(arr));
  }
  public static int Binary(int [] arr){

    int lo=0;
    int hi=arr.length-1;
    while(lo<=hi){
      int mid = (lo+hi)/2;
      if((arr[mid-1]==0 && arr[mid]==1)){
        return mid;
      }else if((arr[mid]==0 && arr[mid+1]==1)){
       return mid+1;
      }else if(arr[mid]==0){
        lo=mid+1;
      }else if(arr[mid]==1 && arr[mid-1]==1){
        hi=mid-1;
      }
    }
    return -1;
  }
}
