package work.DynamicProgramming;

/**
 * @author abaka
 * @date 2019/7/26 19:12
 */
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0)
                return 0;
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 1; i < m; i++){
                    grid[i][0] = grid[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < n; i++){
                    grid[0][i] = grid[0][i - 1] + grid[0][i];
            }

            for (int i = 1; i < m; i++){
                for (int j = 1; j < n; j++){
                        grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
                    }
                }

            return grid[m - 1][n - 1];
        }
    }
}
