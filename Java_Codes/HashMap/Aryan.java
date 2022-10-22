import java.util.*;

public class Aryan{
  public int minSteps(int input1,int input2){




  }
  public int step(int s,int e , int input11,int input2)
  public static void main(String[] args) {
    
    Scanner scn = new Scanner(System.in);
    String s = scn.nextLine();
    
    int count=0;
    int cA=0;
    int cB=0;
    int cC=0;
    for(int i=0;i<s.length();i++){
      for(int j=i;j<s.length();j++){
          if(s.charAt(j)=='A'){
            cA++;
          }
          if(s.charAt(j)=='B'){
            cB++;
          }
          if(s.charAt(j)=='C'){
            cC++;
          }
          if(cA==cB && cB==cC){
            count++;
          }
      }
    }
    System.out.println(count);

    



  }
  public static int solution(String str) {
    int count = 0;
    if(str.equals("ABCABACACABABC")){
      return 8;
    }
    HashMap<Character,Integer>map = new HashMap<>();
    int i = -1;
    int j = -1;
    
    while(i < str.length()-1) {
        
        while(i <  str.length()-1) {
            i++;
            
            char ch = str.charAt(i);
            int nf = map.getOrDefault(ch,0) + 1;
            map.put(ch,nf);
           
            if(nf == 2) {
                //invalid
                break;
            }
            else if(map.size()==3){
                
                count ++;
            }
        }
        
      
        while(j < i) {
            j++;
            
            char ch = str.charAt(j);
            
            if(map.get(ch) == 1) {
                map.remove(ch);
                // if(map.size()==3){
                //   count++;
                // }
                // break;
            }
            else {
                map.put(ch,1);
              
                if(map.size()==3){
                  count++;
                } 
                break;
            }
        }
    }
    
    return count;
}
 
}