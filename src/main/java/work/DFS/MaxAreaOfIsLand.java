package work.DFS;

/**
 * @author abaka
 * @date 2019/7/30 15:43
 */

/**
 * 岛屿的最大面积
 */
public class MaxAreaOfIsLand {
    class Solution {
        private int[][] points = {{0,1},{0,-1},{1,0},{-1,0}};

        public int dfs(int[][] grid,int row,int col,int x,int y){
            int count = 0;
            if(grid[x][y] == 1){
                count++;
                for(int i = 0; i < 4; i++){
                    int newx = x + points[i][0];
                    int newy = y + points[i][1];
                    if(newx < 0 || newy < 0 || newx >= row || newy >= col){
                        continue;
                    }
                    grid[x][y] = 2;
                    count += dfs(grid, row, col, newx, newy);
                }
            }
            return count;
        }

        public int maxAreaOfIsland(int[][] grid) {
            if (grid.length == 0)
                return 0;
            int row = grid.length;
            int col = grid[0].length;
            int max = 0;
            for (int i = 0; i < row; i++){
                for (int j = 0; j < col; j++){
                    if (grid[i][j] == 1){
                        int n = dfs(grid, row, col, i ,j);
                        max = n > max ? n : max;
                    }
                }
            }
            return max;
        }
    }
}
