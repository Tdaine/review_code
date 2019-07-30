package work.DFS;

/**
 * @author abaka
 * @date 2019/7/30 14:10
 */

/**
 * 岛屿周长
 */
public class IsLandPerimeter {
    int[][] points = {{1,0},{-1,0},{0,-1},{0,1}};
    public int dfs(int[][] grid,int row,int col,int x,int y,int[][] book){
        int count = 0;
        book[x][y] = 1;
        if(x == 0)
            count++;
        if(y == 0)
            count++;
        if(x == row - 1)
            count++;
        if(y == col - 1)
            count++;
        for(int i = 0; i < 4; i++){
            int newX = x + points[i][0];
            int newY = y + points[i][1];
            if(newX < 0 || newX >= row || newY < 0 || newY >= col)
                continue;
            if(grid[newX][newY] == 0)
                count++;
            else if(grid[newX][newY] == 1 && book[newX][newY] == 0)
                count +=dfs(grid,row,col,newX,newY,book);
        }
        return count;
    }


    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] book = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1)
                    return dfs(grid,row,col,i,j,book);
            }
        }
        return 0;
    }
}
