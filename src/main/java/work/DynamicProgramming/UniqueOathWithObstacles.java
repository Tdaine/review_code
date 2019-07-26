package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 18:51
 */
public class UniqueOathWithObstacles {
    /**
     * 题目描述：
     *   机器人还是要从网格左上角到达右下角，
     *   但是网格中添加了障碍物，障碍物用1表示
     */
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 0)
                return 0;
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] arr = new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int i = 0; i < m; i++){
                if (obstacleGrid[i][0] == 1)
                    break;
                else
                    arr[i][0] = 1;
            }

            for (int i = 0; i < n; i++){
                if (obstacleGrid[0][i] == 1)
                    break;
                else
                    arr[0][i] = 1;
            }

            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                    if (obstacleGrid[i][j] == 1){
                        arr[i][j] = 0;
                    }
                    else{
                        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                    }
                }
            }
            return arr[m - 1][n - 1];
        }
    }
}
