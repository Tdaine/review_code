package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/9/1 17:23
 */

/**
 * 题目描述：
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerBreak {
    class Solution{
        /**
         * 使用贪心算法；
         * 查找规律可以发现，4以后的数字所有的拆分情况都没有2和3作为因子拆分出来的积大
         * 而2作为因子拆分出来的没有3作为因子拆分出来的大
         * 所以尽可能的把所有的数都拆分为3，这样求出来的积是最大的
         * @param n
         * @return
         */
        public int integerBreak(int n){
            if (n <= 2)
                return 1;
            if (n == 3)
                return 2;
            if (n == 4)
                return 4;

            //接下来就是n > 4的情况
            int res = 1;
            while (n > 4){
                n = n - 3;
                res *= 3;
            }
            res *= n;
            return res;
        }

    }

    class Solution2{
        /**
         * 使用动态规划
         * 思想：将数字n用暴力法进行分解，每种情况都考虑到，
         *     n
         *    / \    \
         *   n-1 n-2 n-3  ...
         *   /  \
         * n-1-1 n-1-2  ...
         * 所以就可以res = max3(res, i * (num - i), i * breakInteger(num - i));求出每一次划分的最大值
         * 三个参数分别代表：之前最大值，num划分为i和num-i的最大值，num划分为i*[(num - i)递归的最大值]
         * 这样可以发现会有重复的情况被求解
         * 所以可以使用动态规划
         * 将每次的情况记录下来，以后使用到直接就去数组中取，不需要再次计算了，
         * 所以有dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
         * 由于上面的贪心算法，知道只需要求出因子为1,2,3的情况，
         * 所以可以简化为dp[i] = max3(Math.max(dp[i - 1], i - 1), 2 * Math.max(dp[i - 2], i - 2), 3 * Math.max(dp[i - 3], i - 3));
         * @param n
         * @return
         */
        public int integerBreak(int n){
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3;i < n + 1; i++){
                dp[i] = max3(Math.max(dp[i - 1],i - 1),2 * Math.max(dp[i - 2],i - 2),3 * Math.max(dp[i - 3],i - 3));
            }
            return dp[n];
        }

        private int max3(int num1,int num2,int num3){
            return Math.max(Math.max(num1,num2),num3);
        }

    }
}
