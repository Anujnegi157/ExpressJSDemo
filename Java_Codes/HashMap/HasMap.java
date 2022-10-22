import java.util.ArrayList;
import java.util.LinkedList;

public class HasMap {
  public static class HashMap<K,V>{
    private class HNode{
      K key;
      V value;
      HNode(K key,V value){
        this.key = key;
        this.value= value;
      }
      
    }
    private int size;
    private LinkedList<E> buckets;
    public HasMap(){
      size=0;
      inibuckets(4);
    }
    public void inibuckets(int n){
      buckets  = new buckets[n];
      for(int i=0;i<n;i++){
        buckets[i]= new LinkedList<>();
      }
    }

    public void put(K key,V value) throws Exception{
      int bi = findBucketIndex(key);
      int di = findWithinBucket(key,bi);
      if(di==-1){
        HNode node = new HNode(key, value);
        buckets[bi].add(node);
        size++;
      }else{
       HNode node = buckets[bi].get(di);
       node.value=value;
      }

      double lamda = size*1.0 /buckets.length;
      if(lamda>2.0){
        rehash();
      }
    }
    public void rehash() throws Exception{
     LinkedList<HNode> [] old_buckets = buckets;
     inibuckets(old_buckets.length*2);
     for(int i=0;i<old_buckets.length;i++){
      for(int j=0;j<old_buckets[i].size();j++){
        Hnode node = old_buckets[i].get(j);
        put(node.key,node.value);
      }
     }

    }
    public int findBucketIndex(K key){
      int hc = key.hashCode();
      int bi = (Math.abs(hc))%buckets.length;
      return bi;
    }
    public int findWithinBucket(K key , int bi){
      for(int i=0;i<buckets[bi].size();i++){
        HNode node = buckets[bi].get(i);
        if(node.key.equals(key)){
          return i;
        }
      }
      return -1;
    }
    public V get(K key) throws Exception{
      int bi = findBucketIndex(key);
      int di = findWithinBucket(key, bi);
      if(di==-1){
        return null;
      }else{
        return buckets[bi].get(di).value;
      }
    }
    public boolean ContainsKey(K key){
      int bi = findBucketIndex(key);
      int di = findWithinBucket(key, bi);
      if(di==-1){
        return false;
      }else{
        return true;
      }
    }
    public V remove(K key) throws Exception{

      int bi = findBucketIndex(key);
      int di = findWithinBucket(key, bi);
      if(di==-1){
        return null;
      }else{
        HNode node = buckets[bi].remove(di);
        size--;
        return node.value;
      }
    }
    public ArrayList<K> keySet() throws Exception{
      ArrayList <k> keys = new ArrayList<>();
      for(int i=0;i<buckets.length;i++){
        for(int j=0;j<buckets[i].size();j++){
          HNode node = buckets[i].get(j);
          keys.add(node.key);
        }
      }
      return keys;


    }
    public int size(){
      return size;
    }
    
  }
}
