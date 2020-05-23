/**
 * @program: Deli-AlgorithmEx
 * @description: 岛屿的最大面积
 * @author: Shaobo.Qian
 * @create: 2020-03-15 21:24
 **/

package first;

public class lc_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int currMax = dfs(i, j, grid);
                    max = Math.max(currMax, max);
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        //terminator
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        //current level
        //通过将经过的岛屿设置为0来确保下次不会重复访问
        grid[i][j] = 0;
        //drill down
        int up = dfs(i, j - 1, grid);
        int down = dfs(i, j + 1, grid);
        int left = dfs(i - 1, j, grid);
        int right = dfs(i + 1, j, grid);

        //下一层返回的和加上当前层的1就是当前层的总结果
        return up + down + left + right + 1;
    }
}
