import java.util.*;

public class mi{
  public static void main(String[] args) {
    int [] arr = {10,23,2};
    Rec(0, arr, "");
    
  }
  

  public static void Rec(int i,int [] arr,String ans){



   if(i==arr.length){
    System.out.println(ans);
    return;
   }

    Rec(i+1, arr, ans+arr[i]+",");
    Rec(i+1, arr, ans);
  }



  
 
  
  
    

   
  
}
