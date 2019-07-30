package work.DFS;

/**
 * @author abaka
 * @date 2019/7/30 13:26
 */

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 */
public class FloodFill {
    class Solution {
        int[][] points = {{0,1},{0,-1},{1,0},{-1,0}};
        public void DFS(int[][] image,int[][] book,int sr,int sc,int newColor,int col,int row,int oldColor){
            image[sr][sc] = newColor;
            book[sr][sc] = 1;
            for (int i = 0; i < 4; i++){
                int newX = sr + points[i][0];
                int newY = sc + points[i][1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col){
                    if (oldColor == image[newX][newY] && book[newX][newY] == 0){
                        DFS(image,book,newX,newY,newColor,col,row,oldColor);
                    }
                }
            }

        }


        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image.length == 0)
                return image;
            int row = image.length;
            int col = image[0].length;
            int oldColor = image[sr][sc];
            int[][] book = new int[row][col];
            DFS(image,book,sr,sc,newColor,col,row,oldColor);
            return image;
        }
    }
}
