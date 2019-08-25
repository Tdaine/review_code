package work.Array;

/**
 * @author abaka
 * @date 2019/8/25 22:25
 */
public class Find {
    class Solution {
        //查找数组中的元素，数组从左向右，从上向下是递增的
        public boolean Find(int target, int [][] array) {
            int x = array.length;
            int y = array[0].length;
            for (int i = x - 1, j = 0; i >= 0 && j < y;){
                if (target == array[i][j]){
                    return true;
                }
                if (target < array[i][j]){
                    i--;
                    continue;
                }
                if (target > array[i][j]){
                    j++;
                    continue;
                }
            }
            return false;
        }
    }
}
