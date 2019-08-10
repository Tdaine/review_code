package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/10 19:41
 */
public class beike3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 2 || n > 50000)
            return;

        double[] arr = new double[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextDouble();
            if (arr[i] < Math.pow(-10,9) || arr[i] > Math.pow(10,9))
                return;
        }

        int[] ret = new int[n];
        for (int i = 0; i < n; i++){
            ret[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j] && ret[j] >= ret[i]){
                    ret[i] = ret[j] + 1;
                }
            }
        }

        int length = ret[0];
        for (int i = 1; i < n; i++){
            if (ret[i] > length)
                length = ret[i];
        }

        if (length == 0)
            length = 1;
        System.out.println(length);
    }
}
