package work.DynamicProgramming;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/7/26 15:45
 */
class Solution {
    public int Fibonacci(int n) {
        Scanner in = new Scanner(System.in);
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int f1 = 1,f2 = 1;
        for(int i = 3; i <= n; i++){
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}

public class Fibonacci {
}
