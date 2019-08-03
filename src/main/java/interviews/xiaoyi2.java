package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/3 15:39
 */
public class xiaoyi2 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
       if (n >= 1){
           for (int i = 0; i < n; i++){
               for (int j = i + 1; j < n; j++){
                   if ((arr[i] + arr[j]) % 2 != 0){
                       if (arr[i] > arr[j]){
                           int temp = arr[i];
                           arr[i] = arr[j];
                           arr[j] = temp;
                       }
                   }
               }
           }
       }

       for (int i = 0; i < arr.length; i++){
           if (i == arr.length - 1)
               System.out.println(arr[i]);
           else
                System.out.print(arr[i] + " ");

       }
    }
}
