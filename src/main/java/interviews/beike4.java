package interviews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/10 20:40
 */
public class beike4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1 || n > 5000)
            return;

        if (n == 1)
            System.out.println(0);

        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextLong();
        }

        if (n == 2){
            if (arr[0] == arr[1])
                return;
            long num = (arr[0] - arr[1]) > 0 ? (arr[0] - arr[1]) : (arr[1] - arr[0]);
            System.out.println(num);
        }

        if (n == 3){
            Arrays.sort(arr);
            long num = 0;
            for (int i = 0; i < n -1; i++){
                num += arr[i + 1] - arr[i];
            }
            long a = (arr[2] - arr[1]) + (arr[3] - arr[2]);
            if (a < num)
                num = a;
            System.out.println(num);
        }
    }
}
