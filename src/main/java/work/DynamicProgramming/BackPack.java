package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 19:30
 */
public class BackPack {
    class Solution {
        /**状态：
         F(i, j): 前i个物品放入大小为j的背包中所获得的最大价值
         状态递推：对于第i个商品，有一种例外，装不下，两种选择，放或者不放
         如果装不下：此时的价值与前i-1个的价值是一样的
         F(i,j) = F(i-1,j)
         如果可以装入：需要在两种选择中找最大的
         F(i, j) = max{F(i-1,j), F(i-1, j - A[i]) + V[i]}
         F(i-1,j): 表示不把第i个物品放入背包中， 所以它的价值就是前i-1个物品放入大小为j的背包的最大价值
         F(i-1, j - A[i]) + V[i]：表示把第i个物品放入背包中，价值增加V[i],但是需要腾出j - A[i]的大小放
         第i个商品
         初始化：第0行和第0列都为0，表示没有装物品时的价值都为0
         F(0,j) = F(i,0) = 0
         返回值：F(n,m)
         * @param m: An integer m denotes the size of a backpack
         * @param A: Given n items with size A[i]
         * @param V: Given n items with value V[i]
         * @return: The maximum value
         */
        public int backPackII(int m, int[] A, int[] V) {
            // write your code here
            if (A.length == 0 || V.length == 0)
                return 0;
            int n = A.length + 1;
            int M = m + 1;
            int[][] result = new int[n][M];

            //前0个物品放在m的包中，价值为0
            for (int i = 0; i < M; i++){
                result[0][i] = 0;
            }
            //前n个物品放在大小为0的包中，价值为0
            for (int i = 0; i < n; i++){
                result[i][0] = 0;
            }

            for (int i = 1; i < n; i++){
                for (int j = 1; j < M; j++){
                    //第i个商品在A中对应的索引为i - 1：i从1开始
                    //如果第i个商品>j，说明可以放不下，所以(i,j)的最大价值和(i - 1,j)相同
                    if (A[i - 1] > j)
                        result[i][j] = result[i - 1][j];
                    //如果可以装下分两种情况，装或不装
                    //如果不装,即为(i - 1,j)
                    //如果装，需要腾出放第i个物品大小的空间：j - A[i - 1]，装入之后的最大价值即为(i - 1,j - A[i - 1]) + v[ i -1]
                    else {
                        int newValue = result[i - 1][j - A[i - 1]] + V[i - 1];
                        result[i][j] = Math.max(newValue,result[i - 1][j]);
                    }
                }
            }
            return result[n - 1][M - 1];
        }

        /**
         * 优化算法：
         * 上面的算法在计算第i行元素时，只用到第i-1行的元素，所以二维的空间可以优化为一维空间
         * 但是如果是一维向量，需要从后向前计算，因为后面的元素更新需要依靠前面的元素未更新（模拟二维矩阵的上一行的
         * 值）的值
         * @param m
         * @param A
         * @param V
         * @return
         */
        public int backPack(int m, int[] A, int[] V){
            int n = m + 1;
            int[] result = new int[n];
            for (int i = 0; i < A.length; i++){
                for (int j = m; j > 0; j--){
                    if (A[i] > j)
                        result[j] = result[j];
                    else {
                        int newValue = result[j - A[i]] + V[i];
                        result[j] = Math.max(newValue,result[j]);
                    }
                }
            }
            return result[m];
        }
    }
}
