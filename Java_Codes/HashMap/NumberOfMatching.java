public class NumberOfMatching {
  public int numMatchingSubseq(String s, String[] words) {
    HashMap<String,Boolean> map = new HashMap<>();
    int c=0;
    for(String val : words){
        if(map.containsKey(val)){
            if(map.get(val)==true){
                c++;
            }
            continue;
        }
        if(isSub(s,val)){
            map.put(val,true);
            c++;
        }else{
            map.put(val,false);
        }
    }
    return c;
}
public boolean isSub(String o ,String b){
    int count = 0;
    int i=0;
    int j=0;
    while(i<o.length() && j<b.length()){
        
        if(o.charAt(i)==b.charAt(j)){
            i++;
            j++;
        }else{
            i++;
        }
    }
    if(j==b.length()){
        return true;
    }else{
        return false;
    }
    
    
    
}
}
