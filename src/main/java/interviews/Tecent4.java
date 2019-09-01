package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/9/1 21:28
 */
public class Tecent4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1 || n > 100000)
            return;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            if (arr[i] < 1|| arr[i] > 100000)
                return;
        }

        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int min = findMin(arr,i,j);
                int maxij = findMax(arr,i,j,min);
                if (maxij > max)
                    max = maxij;
            }
        }
        System.out.println(max);
    }

    private static int findMin(int[] arr,int start,int end){
        int min = arr[start];
        for (int i = start + 1; i <= end; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMax(int[] arr,int start,int end,int min){
        int count = 0;
        for (int i = start; i <= end; i++){
            count += arr[i];
        }
        return min * count;
    }
}
