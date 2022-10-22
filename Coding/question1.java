import java.util.*;
public class question1{


  public static void main(String [] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i]=scn.nextInt();
    }
    Arrays.sort(arr);
    rearrange(arr);
    for(int val:arr){
      System.out.print(val+" ");
    }
    
  }
  public static void rearrange(int []arr){

    int [] ans = new int[arr.length];
    int i=0;
    int j=arr.length-1;
    boolean flag = true;
    int k =0;
    while(i<=j){
      if(flag){
        ans[k]=arr[j];
        k++;
        j--;
        flag = false;
      }else if(flag==false){
        ans[k]=arr[i];
        k++;
        i++;
        flag = true;
      }
    }
    for(int s=0;s<ans.length;s++){
      arr[s]=ans[s];
    }
  }

}
