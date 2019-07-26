package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 15:49
 */
public class JumpFloor {
    /**
     * 状态：
     *     子状态：跳上1级，2级，3级，...，n级台阶的跳法数
     *       f(n)：还剩n个台阶的跳法数
     * 状态递推：
     * n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级 跳1级，剩下n-1级，则剩下跳法是f(n-1)
     * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
     * f(n) = f(n-1)+f(n-2)+...+f(n-n)
     * f(n) = f(n-1)+f(n-2)+...+f(0)
     * f(n-1) = f(n-2)+...+f(0)
     * f(n) = 2*f(n-1)
     *   
     * 初始值：
     * f(1) = 1
     * f(2) = 2*f(1) = 2
     * f(3) = 2*f(2) = 4
     * f(4) = 2*f(3) = 8
     * 所以它是一个等比数列
     * f(n) = 2^(n-1)
     * @param target
     * @return
     */
    private int solution(int target){
        if (target <= 0)
            return 0;
        int total = 1;
        for (int i = 2; i <= target; i++){
            total = total * 2;
        }
        return total;
    }

    /**
     * 每个台阶看成一个位置，除过最后一个位置，其它位置都有两种可能性，
     * 所以总的排列数为2^(n-1)*1 = 2^(n - 1)
     * @param target
     * @return
     */
    private int solution2(int target){
        if (target <= 0)
            return 0;
        return 1 << (target - 1);
    }

    /**
     * 现在让它变成一个正常的青蛙，限制它一次只能跳1阶或者2阶，
     * @param target
     * @return
     */
    private int solution3(int target){
        if (target <= 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= target; i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
