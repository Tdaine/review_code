package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 16:26
 */
public class FindGreatSum {
    /**
     * 方法：动态规划
     * 状态：
     *   子状态：长度为1，2，3，...,n的子数组和的最大值
     *   F(i):长度为i的子数组和的最大值，这种定义不能形成递推关系，舍弃
     *   F(i):以array[i]为末尾元素的子数组和的最大值
     * 状态递推：
     *   F(i) = max(F(i-1) + array[i]，array[i])
     *   F(i) = （F(i-1) > 0）? F(i-1) + array[i] : array[i]
     * 初始值：F(0) = array[0]
     * 返回结果：
     *   maxsum：所有F(i)中的最大值
     *   maxsum = max(maxsum，F(i))
     */
    class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            int[] fMax = new int[array.length];
            fMax[0] = array[0];
            int max = array[0];
            for (int i = 1; i < array.length; i++){
                fMax[i] = Math.max(array[i],fMax[i - 1] + array[i]);
                max = (fMax[i] > max) ? fMax[i] : max;
            }
            return max;
        }
    }
}
