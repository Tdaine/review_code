package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 16:16
 */

/**
 * 牛客网上另一个题目：矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Squareness {
    class Solution {
        public int RectCover(int target) {
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
}
