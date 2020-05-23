/**
 * @program: Deli-AlgorithmEx
 * @description: 岛屿的周长
 * @author: Shaobo.Qian
 * @create: 2020-04-21 07:53
 **/

package first;

/**
 * @question:  1.可能访问到哪三种格子,不同的访问情况和岛屿的周长有什么关系呢？2.dfs 解决格子问题的通用思路?
 * @author Shaobo.Qian
 * @date 2020/4/21
 */
public class lc_463 {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        //1.terminator
        //terminator 1.1: 函数因为「坐标 (r, c) 超出网格范围」返回，对应周长中一条黄色的边
        if (!inArea(grid, r, c)) {
            return 1;
        }
        //terminator 1.2: 函数因为「当前格子是海洋格子」,访问到海洋格子,对应周长中一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }
        //terminator 1.3: 已访问过(函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系)
        if (grid[r][c] == 2) {
            return 0;
        }
        //2.标记为已访问过
        grid[r][c] = 2;

        //3.drill down
        return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);

    }

    /**
     * // 判断坐标 (r, c) 是否在网格中
     * @author Shaobo.Qian
     * @date 2020/4/21
     */
    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }



}
