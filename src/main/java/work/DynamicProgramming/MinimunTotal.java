package work.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Condition;

/**
 * @author abaka
 * @date 2019/7/26 17:40
 */
public class MinimunTotal {
    class Solution {
        /**
         * 状态：F（i,j)：从(i,j)到最后一行的最短路径和
         * F(i,j): min(F(i + 1, j) ,F(i + 1, j + 1)) + a[i][j];
         * 初始状态：F(row - 1,j) = a[row - 1][j];
         * 返回结果：F(0,0)
         * @param triangle
         * @return
         */
        public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

            for (int i = triangle.size() - 2; i >= 0; i--){
                for (int j = 0; j < triangle.get(i).size(); j++){
                    int min = Math.min(triangle.get(i + 1).get(j),triangle.get(i + 1).get( j + 1));
                    triangle.get(i).set(j,triangle.get(i).get(j) + min);
                }
            }
            return triangle.get(0).get(0);
        }
    }

}
