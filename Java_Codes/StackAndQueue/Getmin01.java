public class Getmin01 {
  class GfG
  {
      int minEle;
      Stack<Integer> st= new Stack<>();
  
      /*returns min element from stack*/
      int getMin()
      {
    // Your code here
     if(st.size()==0){
         return -1;
     }else{
         return minEle;
     }
    
      }
      
      /*returns poped element from stack*/
      int pop()
      {
    // Your code here
    if(st.size()==0){
        return -1;
    }else if(st.peek()<minEle){
       //  ambiguity
       int ov = 2*minEle-st.pop();
       int rv = minEle;
       minEle=ov;
       return rv;
    }else{
        return st.pop();
    }
     
      }
  
      /*push element x into the stack*/
      void push(int x)
      {
          if(st.size()==0){
              st.push(x);
              minEle=x;
          }else if(x<minEle){
              int enc = x+(x-minEle);
              st.push(enc);
              minEle = x;
              
          }else{
              st.push(x);
          }
    // Your code here	
      }	
  } 
}
