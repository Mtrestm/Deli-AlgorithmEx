/**
 * todo:
 * @program: Deli-AlgorithmEx
 * @description: 岛屿数量
 * @author: Shaobo.Qian
 * @create: 2020-04-20 07:42
 **/

package first;

public class lc_200 {

    public static void main(String[] args) {

    }

    int rows, cols;

    /**
     * @question 1:网格类问题 DFS 通用思路? 2.网格类问题如何访问相邻结点? 3.网格类问题如何判断 base case(即terminator,跳出递归) 4.如何避免重复遍历访问已访问过的格子?
     * DFS
     * @author Shaobo.Qian
     * @date 2020/4/20
     * @link https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
     */
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows <= 0) return 0;
        cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        //1.terminator
        // 判断 base case
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if (!isValidateIdx(i, j, grid)) {
            return;
        }
        //2.current level
        // 将格子标记为「已遍历过」
        grid[i][j] = '0';
        //3.drill down
        // 访问上、下、左、右四个相邻结点
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private boolean isValidateIdx(int i, int j, char[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return false;
        }
        return true;
    }
}
