import java.util.*;
//  time complexity = o(n square)
//  time complexity in optimesd - o(n*n);
public class bubbleSort{
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=scn.nextInt();
    }
    BubbleSort(arr);
    for(int i=0;i<n;i++){
      System.out.print(arr[i]+" ");
    }
  }
  public static boolean isSmaller(int [] arr,int i,int j) {
   if(arr[i]<arr[j]){
    return true;
   }else{
    return false;
   }

    
  }
  public static void BubbleSort(int [] arr){
    for(int i=0;i<arr.length-1;i++){
      boolean cond = false;
      for(int j=1;j<arr.length-i;j++){
        if(isSmaller(arr,j,j-1)){
          cond= true;
          int temp = arr[j];
          arr[j]=arr[j-1];
          arr[j-1]=temp;
        }
      }
      if(cond==false){
        //   System.out.println("yea sorted");
            break;
        }
    }
    

   
  }
}