/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-03-25 22:36
 **/

package first;

public class lc_892 {
    public static void main(String[] args) {
//        int[][] grid = {{2}};
        int[][] grid = {{1, 2}, {3, 4}};
        int res = surfaceArea(grid);
        System.out.println("res = " + res);

    }
    /**
     * @author Shaobo.Qian
     * @date 2020/3/25
     */
    public static int surfaceArea(int[][] grid) {
        int row = grid.length;
        if (row <= 0)
            return 0;
        int col = grid[0].length;

        int verticalOverlap = 0;//垂直重叠
        int rowOverlap = 0;//横向重叠
        int colOverlap = 0;//纵向重叠
        int sum = 0;//立方体个数

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += grid[i][j];
                // 累加垂直重叠部分
                if (grid[i][j] > 1)
                    verticalOverlap += grid[i][j] - 1;
                //累加横向重叠部分
                if (i > 0)
                    colOverlap += Math.min(grid[i - 1][j], grid[i][j]);

                //累加纵向重叠部分
                if (j > 0)
                    rowOverlap += Math.min(grid[i][j - 1], grid[i][j]);
            }
        }
        return sum * 6 - 2 * (verticalOverlap + rowOverlap + colOverlap);
    }
}
