package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/10 19:18
 */
public class beike2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 0 || n > 100)
            return;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            if (arr[i] < 0|| arr[i] > 10000)
                return;
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            int num = arr[i];
            int flag = 0;
            for (int j = 0; j < n; j++){
                if (j == i)
                    continue;
                for (int k = 0; k < n; k++){
                    if (k == j || k == i)
                        continue;
                    if (num == arr[j] + arr[k])
                        flag++;
                }
            }
            if (flag != 1)
                count++;
        }
        System.out.println(count);
    }
}
