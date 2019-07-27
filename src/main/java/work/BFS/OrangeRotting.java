package work.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author abaka
 * @date 2019/7/27 17:27
 */
class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

/**
 * 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 *     值 0 代表空单元格；
 *     值 1 代表新鲜橘子；
 *     值 2 代表腐烂的橘子。
 *
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *
 */

public class OrangeRotting {

    class Solution {
        int[][] points = {{0,1},{1,0},{0,-1},{-1,0}};
        public int orangesRotting(int[][] grid) {
            Queue<Point> queue = new LinkedList<Point>();
            if (grid.length == 0)
                return 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == 2)
                        ((LinkedList<Point>) queue).addLast(new Point(i,j));
                }
            }
            int minTime = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                int flage = 0;
                while (size-- > 0){
                    Point point = queue.poll();
                    for (int i = 0; i < 4; i++){
                        int newx = point.getX() + points[i][0];
                        int newy = point.getY() + points[i][1];
                        if (newx < 0 || newx >= grid.length || newy < 0 || newy >= grid[0].length)
                            continue;
                        if (grid[newx][newy] == 1){
                            ((LinkedList<Point>) queue).addLast(new Point(newx,newy));
                            grid[newx][newy] = 2;
                            flage = 1;
                        }
                    }
                }
                if (flage == 1)
                    minTime++;
            }

            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == 1)
                        return -1;
                }
            }
            return minTime;
        }
    }
}
