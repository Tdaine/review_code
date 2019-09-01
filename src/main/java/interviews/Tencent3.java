package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/9/1 20:41
 */
public class Tencent3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            long[] ai = new long[n + 1];
            long count = 0;
            for (int i = 1; i <= n; i++){
                ai[i] = in.nextInt();
                count += ai[i];
            }
            if (m >= n && m >= count)
                System.out.println(n + 1);
            else {
                count = 0;
                int stop = 0;
                int time = 0;
                for (int i = 1; i <= n; i++){
                    if (count < m){
                        count+= ai[i];
                        if (count >= m){
                            time += i - stop + 1;
                            count = count - m;
                            while (count >= m){
                                count = count - m;
                                time++;
                            }
                            stop = i;
                        }
                    }
                }
                time += n - stop + 1;
                System.out.println(time);
            }
        }
    }
}
