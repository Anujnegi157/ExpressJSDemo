package ArrayAndStrings;
import java.util.*;
public class longestCommonPrefix {
public static void main(String[] args) {
 
  String [] arr = {"geeks","geeksforgreek","geeksonly","gee"};
  int min = Integer.MAX_VALUE;
  Arrays.sort(arr);
  String a="";
  for(int i=0;i<arr.length-1;i++){
    min = Math.min(min,longestPrefix(arr[i], arr[i+1]));
    if(min==Integer.MAX_VALUE){
      // return "-1";
      System.out.println("-1");
   }else{
       
       a=arr[i].substring(0,min);
   }
  }
 
  // System.out.println(longestPrefix(arr[0],arr[1]));
  System.out.println(a);
}
public static int  longestPrefix(String a,String b) {
  int common =0;
  int i=0;
  int j=0;

  while(i<a.length() && j<b.length()){
    if(a.charAt(i)==b.charAt(j)){
      // System.out.println(a.charAt(i));
      // System.out.println(b.charAt(j));
      i++;
      j++;
      common++;
    }else{
      return common;
    }
  }
  return common;
}  
}
