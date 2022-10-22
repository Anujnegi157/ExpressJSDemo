import java.util.Arrays;

public class BinarySearch {
  public static void main(String[] args) {
    
    int [] arr = {12,3,13,124,3,34,3,24,32,5,43,25,433,4,534,534,6,3,6,5,6,534,4,5,64,56,45,6,45,6,45,6,456,4};
    Arrays.sort(arr);
    System.out.println(arr[31]);

    System.out.println(binarysearch(arr, arr.length, 534));
  }
  public static int binarysearch(int arr[], int n, int k) {
    // code here
    int i=0;
    int j=arr.length-1;
    while(i<=j){
        int mid = (i+j)/2;
        if(arr[mid]==k){
            return mid;
        }else if(arr[mid]<k){
            i=mid+1;
        }else{
            j=mid-1;
        }
    }
    return -1;
}
}
