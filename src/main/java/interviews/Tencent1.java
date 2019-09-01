package interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/9/1 20:04
 */
public class Tencent1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] key = new int[n];
        int[] box = new int[m];
        int jishu1 = 0;
        int oushu1 = 0;
        int jishu2 = 0;
        int oushu2 = 0;
        for (int i = 0; i < n; i++){
            key[i] = in.nextInt();
            if (key[i] % 2 == 0){
                oushu1++;
            }else {
                jishu1++;
            }
        }
        for (int i = 0; i < m; i++){
            box[i] = in.nextInt();
            if (box[i] % 2 == 0){
                oushu2++;
            }else {
                jishu2++;
            }
        }

        int count = jishu1 > oushu2 ? oushu2 : jishu1;
        count += (oushu1 > jishu2 ? jishu2 : oushu1);

        System.out.println(count);
        /**
         * Scanner in = new Scanner(System.in);
         *         int n = in.nextInt();
         *         int m = in.nextInt();
         *         int[] key = new int[n];
         *         int[] box = new int[m];
         *         for (int i = 0; i < n; i++){
         *             key[i] = in.nextInt();
         *         }
         *         for (int i = 0; i < m; i++){
         *             box[i] = in.nextInt();
         *         }
         *         int count = 0;
         *         for (int i = 0; i < n; i++){
         *             for (int j = 0; j < m;j++){
         *                 if (box[j] != -1){
         *                     if ((key[i] + box[j]) % 2 != 0){
         *                         key[i] = -1;
         *                         box[j] = -1;
         *                         count++;
         *                         break;
         *                     }
         *                 }
         *             }
         *         }
         *         System.out.println(count);
         */
    }
}
