package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/3 15:23
 */
public class xiaoyi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1)
            return;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        int q = in.nextInt();
        if (q > 10000)
            return;
        for (int i = 0; i < q; i++){
            int q1 = in.nextInt();
            if (arr[q1 - 1] < 0 || arr[q1 - 1] > 150)
                return;
            float count = 0;
            for (int j = 0; j < n; j++){
                if (arr[j] <= arr[q1 - 1])
                    count++;
            }
            count = count - 1;
            System.out.printf("%6f",(count / n) * 100);
            System.out.println();
        }
    }
}
