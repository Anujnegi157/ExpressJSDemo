import java.util.*;
import java.util.Stack;
public class CandyCrush {
  
public static void main(String[] args) {
  
}
public static class Pair{
 char  val;
 int count;
 Pair(){

 }
 Pair(char val,int count){
  this.val = val;
  this.count =count;
 }
}
public static String reduced_String(int k, String s)
    {
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
          if(st.size()==0){
            st.push(new Pair(s.charAt(i),1));
          }else if(st.peek().val==s.charAt(i) && st.peek().count+1<k){
            st.push(new Pair(s.charAt(i),st.peek().count+1));
          }else if(st.peek().val==s.charAt(i) && st.peek().count+1==k){
            int temp = k;
            while(temp>0){
              st.pop();
              temp--;
            }
          }else{
            st.push(new Pair(s.charAt(i),1));
          }
        }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
          sb.append(st.pop().val);
        }
        return sb.reverse().toString();
        
    }

}
