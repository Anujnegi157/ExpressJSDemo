// public class PaintHouse {
  import java.io.*;
import java.util.*;

public class PaintHouse {
    public static int cost(int i,int a,int [][] arr){
        if(i==arr.length){
            return 0;
        }
        // 1 for red prev 0
        // 2 for blue prev 1
        // 3 for green prev 2
        int cost = 0;
        if(a==1){
            cost =Math.min(arr[i][1]+cost(i+1,2,arr),arr[i][2]+cost(i+1,3,arr));
            
        }else if(a==2){
             cost = Math.min(arr[i][0]+cost(i+1,1,arr),arr[i][2]+cost(i+1,3,arr));
            
            
        }else{
            cost = Math.min(arr[i][0]+cost(i+1,1,arr),arr[i][1]+cost(i+1,2,arr));
        }
        return cost;
        
    }

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            // String str = br.readLine();
            // String[] items = str.split(" ");
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
            arr[i][2] = scn.nextInt();
        }

        // long red = arr[0][0];
        // long blue = arr[0][1];
        // long green = arr[0][2];

        // for (int i = 1; i < arr.length; i++) {
        //     long nred = arr[i][0] + Math.min(blue, green);
        //     long nblue = arr[i][1] + Math.min(red, green);
        //     long ngreen = arr[i][2] + Math.min(red, blue);

        //     red = nred;
        //     blue = nblue;
        //     green = ngreen;
        // }

        System.out.println(Math.min(arr[0][0]+cost(1,1,arr), Math.min(arr[0][1]+cost(1,2,arr), arr[0][2]+cost(1,3,arr))));
    }
}

