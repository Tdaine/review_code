package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 18:43
 */
public class UniquePaths {
    /**
     * 题目描述：
     *   在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动，
     *   机器人试图到达网格的右下角，有多少可能的路径。
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++){
                arr[i][0] = 1;
            }

            for (int i = 0; i < n; i++){
                arr[0][i] = 1;
            }

            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
            return arr[m - 1][n - 1];
        }
    }
}
