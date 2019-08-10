package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/10 19:05
 */
public class beike1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <= 2 || n > 100)
            return;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextLong();
        }

        long min = Long.MAX_VALUE;
        long[] ret = new long[2];
        for (int i = 0; i < n - 1; i++){
            if (arr[i] > arr[i + 1]){
                long m = arr[i] - arr[i+1];
                if (m < min){
                    min = m;
                    ret[0] = arr[i];
                    ret[1] = arr[i + 1];
                }
            }else {
                long m = arr[i + 1] - arr[i];
                if (m < min){
                    min = m;
                    ret[0] = arr[i];
                    ret[1] = arr[i + 1];
                }
            }
        }
        System.out.println(ret[0] + " " + ret[1]);
    }
}
